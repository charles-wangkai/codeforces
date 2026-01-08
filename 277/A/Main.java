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

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] a = new int[n][];
    for (int i = 0; i < a.length; ++i) {
      int k = sc.nextInt();
      a[i] = new int[k];
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }
    System.out.println(solve(a, m));

    sc.close();
  }

  static int solve(int[][] a, int m) {
    int result = 0;
    boolean[] used = new boolean[m + 1];
    Dsu dsu = new Dsu(m + 1);
    for (int[] ai : a) {
      if (ai.length == 0) {
        ++result;
      } else {
        for (int j = 0; j < ai.length; ++j) {
          used[ai[j]] = true;

          if (j + 1 < ai.length) {
            dsu.union(ai[j], ai[j + 1]);
          }
        }
      }
    }
    result +=
        Math.max(
            0,
            (int) IntStream.rangeClosed(1, m).filter(i -> used[i]).map(dsu::find).distinct().count()
                - 1);

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
