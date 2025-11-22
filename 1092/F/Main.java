import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] u = new int[n - 1];
    int[] v = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(a, u, v));

    sc.close();
  }

  static long solve(int[] a, int[] u, int[] v) {
    int n = a.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    long[] subtreeSums = new long[n];
    long[] costs = new long[n];
    costs[0] = search1(subtreeSums, a, adjLists, 0, -1, 0);

    search2(costs, adjLists, subtreeSums, -1, 0);

    return Arrays.stream(costs).max().getAsLong();
  }

  static void search2(
      long[] costs, List<Integer>[] adjLists, long[] subtreeSums, int parent, int node) {
    if (parent != -1) {
      costs[node] = costs[parent] - 2 * subtreeSums[node] + subtreeSums[0];
    }

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search2(costs, adjLists, subtreeSums, node, adj);
      }
    }
  }

  static long search1(
      long[] subtreeSums, int[] a, List<Integer>[] adjLists, int depth, int parent, int node) {
    long cost = (long) a[node] * depth;
    subtreeSums[node] = a[node];

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        cost += search1(subtreeSums, a, adjLists, depth + 1, node, adj);
        subtreeSums[node] += subtreeSums[adj];
      }
    }

    return cost;
  }
}