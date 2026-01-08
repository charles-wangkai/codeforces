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
      int m1 = sc.nextInt();
      int m2 = sc.nextInt();
      int[] fu = new int[m1];
      int[] fv = new int[m1];
      for (int i = 0; i < m1; ++i) {
        fu[i] = sc.nextInt();
        fv[i] = sc.nextInt();
      }
      int[] gu = new int[m2];
      int[] gv = new int[m2];
      for (int i = 0; i < m2; ++i) {
        gu[i] = sc.nextInt();
        gv[i] = sc.nextInt();
      }

      System.out.println(solve(n, fu, fv, gu, gv));
    }

    sc.close();
  }

  static int solve(int n, int[] fu, int[] fv, int[] gu, int[] gv) {
    Dsu gDsu = new Dsu(n);
    for (int i = 0; i < gu.length; ++i) {
      gDsu.union(gu[i] - 1, gv[i] - 1);
    }

    int result = 0;
    Dsu fDsu = new Dsu(n);
    for (int i = 0; i < fu.length; ++i) {
      if (gDsu.find(fu[i] - 1) != gDsu.find(fv[i] - 1)) {
        ++result;
      } else {
        fDsu.union(fu[i] - 1, fv[i] - 1);
      }
    }
    result += fDsu.buildLeaderToGroup().size() - gDsu.buildLeaderToGroup().size();

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
