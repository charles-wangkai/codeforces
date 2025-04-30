import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(a, u, v));

    sc.close();
  }

  static int solve(int[] a, int[] u, int[] v) {
    int n = a.length;

    boolean[][] matches = new boolean[n][n];
    for (int i = 0; i < u.length; ++i) {
      matches[u[i] - 1][v[i] - 1] = true;
      matches[v[i] - 1][u[i] - 1] = true;
    }

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        for (int k = j + 1; k < n; ++k) {
          if (matches[i][j] && matches[j][k] && matches[k][i]) {
            result = Math.min(result, a[i] + a[j] + a[k]);
          }
        }
      }
    }

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }
}