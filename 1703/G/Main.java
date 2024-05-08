import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int SIZE = 30;

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
    long[] dp = new long[SIZE + 1];
    Arrays.fill(dp, Long.MIN_VALUE);
    dp[0] = 0;

    for (int ai : a) {
      long[] nextDp = new long[dp.length];
      Arrays.fill(nextDp, Long.MIN_VALUE);

      for (int i = 0; i < dp.length; ++i) {
        if (dp[i] != Long.MIN_VALUE) {
          nextDp[i] = Math.max(nextDp[i], dp[i] - k + (ai >> i));
          nextDp[Math.min(SIZE, i + 1)] =
              Math.max(nextDp[Math.min(SIZE, i + 1)], dp[i] + (ai >> (i + 1)));
        }
      }

      dp = nextDp;
    }

    return Arrays.stream(dp).max().getAsLong();
  }
}