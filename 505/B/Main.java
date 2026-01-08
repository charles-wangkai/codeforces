import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    int[] c = new int[m];
    for (int i = 0; i < m; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }
    int q = sc.nextInt();
    int[] u = new int[q];
    int[] v = new int[q];
    for (int i = 0; i < q; i++) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }
    System.out.print(solve(n, a, b, c, u, v));

    sc.close();
  }

  static String solve(int n, int[] a, int[] b, int[] c, int[] u, int[] v) {
    int m = a.length;

    Dsu[] dsuArray = new Dsu[m + 1];
    for (int i = 0; i < dsuArray.length; ++i) {
      dsuArray[i] = new Dsu(n + 1);
    }

    for (int i = 0; i < m; i++) {
      dsuArray[c[i]].union(a[i], b[i]);
    }

    return IntStream.range(0, u.length)
        .map(
            i ->
                (int)
                    Arrays.stream(dsuArray).filter(dsu -> dsu.find(u[i]) == dsu.find(v[i])).count())
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
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
