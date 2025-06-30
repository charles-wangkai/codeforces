import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
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
    }

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

    long[] threats = new long[n];
    search(threats, a, adjLists, -1, 0, 0);

    return Arrays.stream(threats).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void search(
      long[] threats,
      int[] a,
      List<Integer>[] adjLists,
      int parent,
      long parentMaxNegSum,
      int node) {
    threats[node] = parentMaxNegSum + a[node];

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(
            threats,
            a,
            adjLists,
            node,
            Math.max(0, -a[node] + Math.max(0, (parent == -1) ? 0 : threats[parent])),
            adj);
      }
    }
  }
}