import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] a, int[] u, int[] v) {
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

    int[] maxDiffs = new int[n];
    search1(maxDiffs, a, adjLists, -1, 0);

    int[] rootedMaxDiffs = new int[n];
    search2(rootedMaxDiffs, adjLists, maxDiffs, 0, -1, 0);

    return Arrays.stream(rootedMaxDiffs).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void search2(
      int[] rootedMaxDiffs,
      List<Integer>[] adjLists,
      int[] maxDiffs,
      int parentDelta,
      int parent,
      int node) {
    rootedMaxDiffs[node] = parentDelta + maxDiffs[node];

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search2(
            rootedMaxDiffs,
            adjLists,
            maxDiffs,
            Math.max(0, maxDiffs[node] - Math.max(0, maxDiffs[adj]) + parentDelta),
            node,
            adj);
      }
    }
  }

  static void search1(int[] maxDiffs, int[] a, List<Integer>[] adjLists, int parent, int node) {
    maxDiffs[node] = (a[node] == 1) ? 1 : -1;
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search1(maxDiffs, a, adjLists, node, adj);
        maxDiffs[node] += Math.max(0, maxDiffs[adj]);
      }
    }
  }
}