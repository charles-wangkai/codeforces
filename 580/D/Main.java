import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] x = new int[k];
    int[] y = new int[k];
    int[] c = new int[k];
    for (int i = 0; i < k; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(a, m, x, y, c));

    sc.close();
  }

  static long solve(int[] a, int m, int[] x, int[] y, int[] c) {
    int n = a.length;

    int[][] adjMatrix = new int[n][n];
    for (int i = 0; i < x.length; ++i) {
      adjMatrix[x[i] - 1][y[i] - 1] = c[i];
    }

    long[][] dp = new long[1 << n][n];
    for (int mask = 0; mask < dp.length; ++mask) {
      Arrays.fill(dp[mask], -1);
    }
    for (int i = 0; i < a.length; ++i) {
      dp[1 << i][i] = a[i];
    }

    for (int mask = 0; mask < dp.length; ++mask) {
      if (Integer.bitCount(mask) < m) {
        for (int last = 0; last < n; ++last) {
          if (dp[mask][last] != -1) {
            for (int curr = 0; curr < n; ++curr) {
              if (((mask >> curr) & 1) == 0) {
                int nextMask = mask + (1 << curr);
                dp[nextMask][curr] =
                    Math.max(dp[nextMask][curr], dp[mask][last] + a[curr] + adjMatrix[last][curr]);
              }
            }
          }
        }
      }
    }

    long result = -1;
    for (int mask = 0; mask < dp.length; ++mask) {
      for (int last = 0; last < n; ++last) {
        result = Math.max(result, dp[mask][last]);
      }
    }

    return result;
  }
}
