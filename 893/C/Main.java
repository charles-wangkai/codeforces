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
    int[] c = new int[n];
    for (int i = 0; i < c.length; i++) {
      c[i] = sc.nextInt();
    }
    int[] x = new int[m];
    int[] y = new int[m];
    for (int i = 0; i < m; i++) {
      x[i] = sc.nextInt() - 1;
      y[i] = sc.nextInt() - 1;
    }
    System.out.println(solve(c, x, y));

    sc.close();
  }

  static long solve(int[] c, int[] x, int[] y) {
    Dsu dsu = new Dsu(c.length);
    for (int i = 0; i < x.length; i++) {
      int xLeader = dsu.find(x[i]);
      int yLeader = dsu.find(y[i]);
      if (xLeader != yLeader) {
        if (c[xLeader] <= c[yLeader]) {
          dsu.union(xLeader, yLeader);
        } else {
          dsu.union(yLeader, xLeader);
        }
      }
    }

    return dsu.buildLeaderToGroup().keySet().stream()
        .mapToInt(leader -> c[leader])
        .asLongStream()
        .sum();
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
