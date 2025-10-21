import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] u = new int[n - 1];
    int[] v = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(u, v));

    sc.close();
  }

  static long solve(int[] u, int[] v) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    int[] subtreeSizes = new int[n];
    buildSubtreeSizes(subtreeSizes, adjLists, -1, 0);

    return search(adjLists, subtreeSizes, Arrays.stream(subtreeSizes).asLongStream().sum(), -1, 0);
  }

  static long search(
      List<Integer>[] adjLists, int[] subtreeSizes, long subtreeSizeSum, int parent, int node) {
    long result = subtreeSizeSum;

    long oldSubtreeSizeSum = subtreeSizeSum;
    int oldNodeSubtreeSize = subtreeSizes[node];
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        int oldAdjSubtreeSize = subtreeSizes[adj];

        subtreeSizes[node] -= subtreeSizes[adj];
        subtreeSizes[adj] += subtreeSizes[node];
        long newSubtreeSizeSum =
            oldSubtreeSizeSum
                - oldNodeSubtreeSize
                + subtreeSizes[node]
                - oldAdjSubtreeSize
                + subtreeSizes[adj];

        result = Math.max(result, search(adjLists, subtreeSizes, newSubtreeSizeSum, node, adj));

        subtreeSizes[adj] = oldAdjSubtreeSize;
        subtreeSizes[node] = oldNodeSubtreeSize;
      }
    }

    return result;
  }

  static void buildSubtreeSizes(
      int[] subtreeSizes, List<Integer>[] adjLists, int parent, int node) {
    subtreeSizes[node] = 1;

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        buildSubtreeSizes(subtreeSizes, adjLists, node, adj);
        subtreeSizes[node] += subtreeSizes[adj];
      }
    }
  }
}