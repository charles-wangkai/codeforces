import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] x = new int[k];
    int[] y = new int[k];
    for (int i = 0; i < k; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(n, x, y));

    sc.close();
  }

  static int solve(int n, int[] x, int[] y) {
    int[] parents = new int[n];
    Arrays.fill(parents, -1);

    for (int i = 0; i < x.length; ++i) {
      int root1 = findRoot(parents, x[i] - 1);
      int root2 = findRoot(parents, y[i] - 1);
      if (root1 != root2) {
        parents[root2] = root1;
      }
    }

    return x.length
        - (n - (int) IntStream.range(0, n).map(i -> findRoot(parents, i)).distinct().count());
  }

  static int findRoot(int[] parents, int node) {
    if (parents[node] == -1) {
      return node;
    }

    parents[node] = findRoot(parents, parents[node]);

    return parents[node];
  }
}