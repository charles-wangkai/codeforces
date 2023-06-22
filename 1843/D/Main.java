import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt() - 1;
        v[i] = sc.nextInt() - 1;
      }
      int q = sc.nextInt();
      int[] x = new int[q];
      int[] y = new int[q];
      for (int i = 0; i < q; ++i) {
        x[i] = sc.nextInt() - 1;
        y[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(u, v, x, y));
    }

    sc.close();
  }

  static String solve(int[] u, int[] v, int[] x, int[] y) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i]].add(v[i]);
      adjLists[v[i]].add(u[i]);
    }

    int[] leafNums = new int[n];
    search(leafNums, adjLists, 0, -1);

    return IntStream.range(0, x.length)
        .mapToLong(i -> (long) leafNums[x[i]] * leafNums[y[i]])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static void search(int[] leafNums, List<Integer>[] adjLists, int node, int parent) {
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(leafNums, adjLists, adj, node);
        leafNums[node] += leafNums[adj];
      }
    }

    leafNums[node] = Math.max(1, leafNums[node]);
  }
}
