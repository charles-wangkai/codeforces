import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int n = a.length;

    int[] parents = IntStream.range(0, n).map(i -> -1).toArray();
    List<String> roads = new ArrayList<>();
    for (int x = 0; x < n; ++x) {
      for (int y = x + 1; y < n; ++y) {
        int rootX = findRoot(parents, x);
        int rootY = findRoot(parents, y);
        if (a[x] != a[y] && rootX != rootY) {
          parents[rootY] = rootX;
          roads.add(String.format("%d %d", x + 1, y + 1));
        }
      }
    }

    if (roads.size() == n - 1) {
      return String.format("YES\n%s", String.join("\n", roads));
    } else {
      return "NO";
    }
  }

  static int findRoot(int[] parents, int node) {
    int root = node;
    while (parents[root] != -1) {
      root = parents[root];
    }

    int p = node;
    while (p != root) {
      int next = parents[p];
      parents[p] = root;

      p = next;
    }

    return root;
  }
}
