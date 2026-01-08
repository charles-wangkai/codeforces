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
    int m1 = sc.nextInt();
    int m2 = sc.nextInt();
    int[] u1 = new int[m1];
    int[] v1 = new int[m1];
    for (int i = 0; i < m1; ++i) {
      u1[i] = sc.nextInt() - 1;
      v1[i] = sc.nextInt() - 1;
    }
    int[] u2 = new int[m2];
    int[] v2 = new int[m2];
    for (int i = 0; i < m2; ++i) {
      u2[i] = sc.nextInt() - 1;
      v2[i] = sc.nextInt() - 1;
    }

    System.out.println(solve(n, u1, v1, u2, v2));

    sc.close();
  }

  static String solve(int n, int[] u1, int[] v1, int[] u2, int[] v2) {
    Dsu dsu1 = buildDsu(n, u1, v1);
    Dsu dsu2 = buildDsu(n, u2, v2);

    List<String> addedEdges = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        int iLeader1 = dsu1.find(i);
        int jLeader1 = dsu1.find(j);
        int iLeader2 = dsu2.find(i);
        int jLeader2 = dsu2.find(j);
        if (iLeader1 != jLeader1 && iLeader2 != jLeader2) {
          dsu1.union(iLeader1, jLeader1);
          dsu2.union(iLeader2, jLeader2);

          addedEdges.add("%d %d".formatted(i + 1, j + 1));
        }
      }
    }

    return "%d\n%s".formatted(addedEdges.size(), String.join("\n", addedEdges));
  }

  static Dsu buildDsu(int n, int[] u, int[] v) {
    Dsu dsu = new Dsu(n);
    for (int i = 0; i < u.length; ++i) {
      dsu.union(u[i], v[i]);
    }

    return dsu;
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
