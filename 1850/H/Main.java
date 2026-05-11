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
      int m = sc.nextInt();
      int[] a = new int[m];
      int[] b = new int[m];
      int[] d = new int[m];
      for (int i = 0; i < m; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
        d[i] = sc.nextInt();
      }

      System.out.println(solve(n, a, b, d) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int[] a, int[] b, int[] d) {
    Dsu dsu = new Dsu(n);
    for (int i = 0; i < a.length; ++i) {
      if (!dsu.union(a[i] - 1, b[i] - 1, d[i])) {
        return false;
      }
    }

    return true;
  }
}

class Dsu {
  int[] parentOrSizes;
  long[] deltas;

  Dsu(int n) {
    parentOrSizes = new int[n];
    Arrays.fill(parentOrSizes, -1);

    deltas = new long[n];
  }

  int find(int a) {
    if (parentOrSizes[a] < 0) {
      return a;
    }

    int parent = parentOrSizes[a];
    int leader = find(parent);
    deltas[a] += deltas[parent];
    parentOrSizes[a] = leader;

    return leader;
  }

  boolean union(int left, int right, int distance) {
    int leftLeader = find(left);
    int rightLeader = find(right);
    long offset = distance + deltas[left] - deltas[right];

    if (leftLeader == rightLeader) {
      if (offset != 0) {
        return false;
      }
    } else {
      parentOrSizes[leftLeader] += parentOrSizes[rightLeader];
      parentOrSizes[rightLeader] = leftLeader;

      deltas[rightLeader] = offset;
    }

    return true;
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