import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p, x, y) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] p, int x, int y) {
    int n = p.length;

    Dsu dsu = new Dsu(n);
    for (int i = 0; i < n; ++i) {
      if (i + x < n) {
        dsu.union(i, i + x);
      }
      if (i + y < n) {
        dsu.union(i, i + y);
      }
    }

    for (List<Integer> group : dsu.buildLeaderToGroup().values()) {
      int[] sortedIndices = group.stream().mapToInt(Integer::intValue).toArray();
      int[] sortedValues = Arrays.stream(sortedIndices).map(index -> p[index]).sorted().toArray();
      for (int i = 0; i < sortedIndices.length; ++i) {
        p[sortedIndices[i]] = sortedValues[i];
      }
    }

    return IntStream.range(0, p.length - 1).allMatch(i -> p[i] < p[i + 1]);
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
