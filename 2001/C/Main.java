import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      StringBuilder result = new StringBuilder("!");
      Dsu dsu = new Dsu(n);
      for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
          if (dsu.find(i) != dsu.find(j)) {
            int v1 = i;
            int v2 = j;
            while (true) {
              System.out.println("? %d %d".formatted(v1 + 1, v2 + 1));
              System.out.flush();

              int x = sc.nextInt() - 1;
              if (x == v1) {
                result.append(" ").append(v1 + 1).append(" ").append(v2 + 1);
                dsu.union(v1, v2);

                break;
              }

              if (dsu.find(x) != dsu.find(v1)) {
                v2 = x;
              } else {
                v1 = x;
              }
            }
          }
        }
      }

      System.out.println(result);
      System.out.flush();
    }

    sc.close();
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
