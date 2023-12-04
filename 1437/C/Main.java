import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      int n = sc.nextInt();
      int[] t = new int[n];
      for (int i = 0; i < t.length; ++i) {
        t[i] = sc.nextInt();
      }

      System.out.println(solve(t));
    }

    sc.close();
  }

  static int solve(int[] t) {
    Arrays.sort(t);

    int[] dp = new int[t.length * 2 + 1];
    for (int i = 1; i < dp.length; ++i) {
      dp[i] = Math.abs(i - t[0]);
    }

    for (int i = 1; i < t.length; ++i) {
      int[] nextDp = new int[dp.length];
      Arrays.fill(nextDp, Integer.MAX_VALUE);

      for (int j = 1; j < nextDp.length; ++j) {
        for (int k = 1; k < j; ++k) {
          if (dp[k] != Integer.MAX_VALUE) {
            nextDp[j] = Math.min(nextDp[j], dp[k] + Math.abs(j - t[i]));
          }
        }
      }

      dp = nextDp;
    }

    return Arrays.stream(dp).min().getAsInt();
  }
}