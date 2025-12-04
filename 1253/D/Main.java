import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(n, u, v));

    sc.close();
  }

  static int solve(int n, int[] u, int[] v) {
    int[] parents = new int[n];
    Arrays.fill(parents, -1);

    for (int i = 0; i < u.length; ++i) {
      int root1 = findRoot(parents, u[i] - 1);
      int root2 = findRoot(parents, v[i] - 1);
      if (root1 < root2) {
        parents[root1] = root2;
      } else if (root1 > root2) {
        parents[root2] = root1;
      }
    }

    int result = 0;
    int maxRoot = -1;
    for (int i = 0; i < n; ++i) {
      int root = findRoot(parents, i);

      if (i <= maxRoot) {
        if (root < maxRoot) {
          parents[root] = maxRoot;

          ++result;
        } else if (root > maxRoot) {
          parents[maxRoot] = root;
          maxRoot = root;

          ++result;
        }
      } else {
        maxRoot = root;
      }
    }

    return result;
  }

  static int findRoot(int[] parents, int node) {
    if (parents[node] == -1) {
      return node;
    }

    parents[node] = findRoot(parents, parents[node]);

    return parents[node];
  }
}