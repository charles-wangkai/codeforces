import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int l = sc.nextInt();
    int k = sc.nextInt();
    int[] d = new int[n];
    for (int i = 0; i < d.length; ++i) {
      d[i] = sc.nextInt();
    }
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(d, a, l, k));

    sc.close();
  }

  static int solve(int[] d, int[] a, int l, int k) {
    int n = d.length;

    int[][] dp = new int[n][n];
    for (int i = 0; i < dp.length; ++i) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    dp[0][0] = 0;

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n; ++i) {
      for (int j = (i == 0) ? 0 : 1; j <= i; ++j) {
        for (int p = i + 1; p < n; ++p) {
          dp[p][j + 1] = Math.min(dp[p][j + 1], dp[i][j] + a[i] * (d[p] - d[i]));
        }

        if (j + 1 >= n - k) {
          result = Math.min(result, dp[i][j] + a[i] * (l - d[i]));
        }
      }
    }

    return result;
  }
}