import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] c = new int[k];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(n, u, v, c));

    sc.close();
  }

  static int solve(int n, int[] u, int[] v, int[] c) {
    Set<Integer> homes = Arrays.stream(c).map(ci -> ci - 1).boxed().collect(Collectors.toSet());

    Dsu dsu = new Dsu(n);
    for (int i = 0; i < u.length; ++i) {
      int leader1 = dsu.find(u[i] - 1);
      int leader2 = dsu.find(v[i] - 1);
      if (leader1 != leader2) {
        if (homes.contains(leader1)) {
          dsu.union(leader1, leader2);
        } else {
          dsu.union(leader2, leader1);
        }
      }
    }

    int homeWithMaxSize = findHomeWithMaxSize(homes, dsu);
    for (int i = 0; i < n; ++i) {
      int leader = dsu.find(i);
      if (!homes.contains(leader)) {
        dsu.union(homeWithMaxSize, leader);
      }
    }

    Map<Integer, Integer> homeToEdgeCount = new HashMap<>();
    for (int i = 0; i < u.length; ++i) {
      int home = dsu.find(u[i] - 1);
      homeToEdgeCount.put(home, homeToEdgeCount.getOrDefault(home, 0) + 1);
    }

    Map<Integer, List<Integer>> homeToGroup = dsu.buildLeaderToGroup();

    return homeToGroup.keySet().stream()
        .mapToInt(
            home ->
                homeToGroup.get(home).size() * (homeToGroup.get(home).size() - 1) / 2
                    - homeToEdgeCount.getOrDefault(home, 0))
        .sum();
  }

  static int findHomeWithMaxSize(Set<Integer> homes, Dsu dsu) {
    Map<Integer, Integer> homeToSize = new HashMap<>();
    for (int i = 0; i < dsu.parentOrSizes.length; ++i) {
      int leader = dsu.find(i);
      if (homes.contains(leader)) {
        homeToSize.put(leader, homeToSize.getOrDefault(leader, 0) + 1);
      }
    }

    return homeToSize.keySet().stream().max(Comparator.comparing(homeToSize::get)).get();
  }
}

class Dsu {
  int[] parentOrSizes;

  Dsu(int n) {
    parentOrSizes = new int[n];
    Arrays.fill(parentOrSizes, -1);
  }

  int find(int a) {
    if (parentOrSizes[a] < 0) {
      return a;
    }

    parentOrSizes[a] = find(parentOrSizes[a]);

    return parentOrSizes[a];
  }

  void union(int a, int b) {
    int aLeader = find(a);
    int bLeader = find(b);
    if (aLeader != bLeader) {
      parentOrSizes[aLeader] += parentOrSizes[bLeader];
      parentOrSizes[bLeader] = aLeader;
    }
  }

  int getSize(int a) {
    return -parentOrSizes[find(a)];
  }

  Map<Integer, List<Integer>> buildLeaderToGroup() {
    Map<Integer, List<Integer>> leaderToGroup = new HashMap<>();
    for (int i = 0; i < parentOrSizes.length; ++i) {
      int leader = find(i);
      leaderToGroup.putIfAbsent(leader, new ArrayList<>());
      leaderToGroup.get(leader).add(i);
    }

    return leaderToGroup;
  }
}
