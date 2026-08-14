import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
    int[] u = new int[n - 1];
    int[] v = new int[n - 1];
    int[] w = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
      w[i] = sc.nextInt();
    }
    int[] q = new int[m];
    for (int i = 0; i < q.length; ++i) {
      q[i] = sc.nextInt();
    }

    System.out.println(solve(u, v, w, q));

    sc.close();
  }

  static String solve(int[] u, int[] v, int[] w, int[] q) {
    int n = u.length + 1;

    int[] sortedEdgeIndices =
        IntStream.range(0, w.length)
            .boxed()
            .sorted(Comparator.comparing(i -> w[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    int index = 0;

    int[] sortedQueryIndices =
        IntStream.range(0, q.length)
            .boxed()
            .sorted(Comparator.comparing(i -> q[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    long[] result = new long[q.length];
    Dsu dsu = new Dsu(n);
    long pairNum = 0;
    for (int queryIndex : sortedQueryIndices) {
      while (index != sortedEdgeIndices.length && w[sortedEdgeIndices[index]] <= q[queryIndex]) {
        int edgeIndex = sortedEdgeIndices[index];

        int leader1 = dsu.find(u[edgeIndex] - 1);
        int leader2 = dsu.find(v[edgeIndex] - 1);
        if (leader1 != leader2) {
          pairNum += (long) dsu.getSize(leader1) * dsu.getSize(leader2);
          dsu.union(leader1, leader2);
        }

        ++index;
      }

      result[queryIndex] = pairNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
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
