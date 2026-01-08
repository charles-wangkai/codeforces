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
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(n, u, v));

    sc.close();
  }

  static int solve(int n, int[] u, int[] v) {
    Dsu dsu = new Dsu(n);
    for (int i = 0; i < u.length; ++i) {
      int leader1 = dsu.find(u[i] - 1);
      int leader2 = dsu.find(v[i] - 1);
      if (leader1 < leader2) {
        dsu.union(leader2, leader1);
      } else if (leader1 > leader2) {
        dsu.union(leader1, leader2);
      }
    }

    int result = 0;
    int maxLeader = -1;
    for (int i = 0; i < n; ++i) {
      int leader = dsu.find(i);

      if (i <= maxLeader) {
        if (leader < maxLeader) {
          dsu.union(maxLeader, leader);

          ++result;
        } else if (leader > maxLeader) {
          dsu.union(leader, maxLeader);
          maxLeader = leader;

          ++result;
        }
      } else {
        maxLeader = leader;
      }
    }

    return result;
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
