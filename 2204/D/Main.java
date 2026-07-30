import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] v = new int[m];
      int[] u = new int[m];
      for (int i = 0; i < m; ++i) {
        v[i] = sc.nextInt();
        u[i] = sc.nextInt();
      }

      System.out.println(solve(n, v, u));
    }

    sc.close();
  }

  static int solve(int n, int[] v, int[] u) {
    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < v.length; ++i) {
      adjLists[v[i] - 1].add(u[i] - 1);
      adjLists[u[i] - 1].add(v[i] - 1);
    }

    int result = 0;
    int[] colors = new int[n];
    for (int i = 0; i < colors.length; ++i) {
      if (colors[i] == 0) {
        Set<Integer> seen = new HashSet<>();
        if (fill(seen, adjLists, colors, i, 1)) {
          result +=
              Math.max(
                  seen.stream().filter(index -> colors[index] == 1).count(),
                  seen.stream().filter(index -> colors[index] == -1).count());
        }
      }
    }

    return result;
  }

  static boolean fill(
      Set<Integer> seen, List<Integer>[] adjLists, int[] colors, int node, int color) {
    if (colors[node] != 0) {
      return colors[node] == color;
    }

    colors[node] = color;
    seen.add(node);

    boolean result = true;
    for (int adj : adjLists[node]) {
      if (!fill(seen, adjLists, colors, adj, -color)) {
        result = false;
      }
    }

    return result;
  }
}