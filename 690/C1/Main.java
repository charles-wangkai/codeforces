import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(n, a, b) ? "yes" : "no");

    sc.close();
  }

  static boolean solve(int n, int[] a, int[] b) {
    int[] parents = new int[n];
    Arrays.fill(parents, -1);

    for (int i = 0; i < a.length; ++i) {
      int root1 = findRoot(parents, a[i] - 1);
      int root2 = findRoot(parents, b[i] - 1);
      if (root1 == root2) {
        return false;
      }

      parents[root2] = root1;
    }

    return IntStream.range(0, n).map(i -> findRoot(parents, i)).distinct().count() == 1;
  }

  static int findRoot(int[] parents, int node) {
    if (parents[node] == -1) {
      return node;
    }

    parents[node] = findRoot(parents, parents[node]);

    return parents[node];
  }
}