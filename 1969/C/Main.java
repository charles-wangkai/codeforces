import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, int k) {
    int n = a.length;

    long[][] dp = new long[n + 1][k + 1];
    for (int i = 0; i < dp.length; ++i) {
      Arrays.fill(dp[i], Long.MAX_VALUE);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= n; ++i) {
      for (int operNum = 0; operNum <= k; ++operNum) {
        int minValue = Integer.MAX_VALUE;
        for (int length = 1; length <= i && length - 1 <= operNum; ++length) {
          minValue = Math.min(minValue, a[i - length]);

          if (dp[i - length][operNum - (length - 1)] != Long.MAX_VALUE) {
            dp[i][operNum] =
                Math.min(
                    dp[i][operNum],
                    (long) minValue * length + dp[i - length][operNum - (length - 1)]);
          }
        }
      }
    }

    return Arrays.stream(dp[n]).min().getAsLong();
  }
}