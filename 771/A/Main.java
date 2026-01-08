import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    System.out.println(solve(n, a, b) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int n, int[] a, int[] b) {
    Dsu dsu = new Dsu(n);
    for (int i = 0; i < a.length; i++) {
      dsu.union(a[i] - 1, b[i] - 1);
    }

    Map<Integer, List<Integer>> leaderToGroup = dsu.buildLeaderToGroup();

    Map<Integer, Integer> leaderToEdgeCount = new HashMap<>();
    for (int ai : a) {
      int leader = dsu.find(ai - 1);
      leaderToEdgeCount.put(leader, leaderToEdgeCount.getOrDefault(leader, 0) + 1);
    }

    return leaderToGroup.keySet().stream()
        .allMatch(
            leader -> {
              int nodeCount = leaderToGroup.get(leader).size();

              return nodeCount * (nodeCount - 1L) / 2 == leaderToEdgeCount.getOrDefault(leader, 0);
            });
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
