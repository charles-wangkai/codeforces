import java.util.Arrays;
import java.util.Scanner;

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

  static int solve(int[] a) {
    int[][] dp = new int[2][2];
    for (int i = 0; i < dp.length; ++i) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    dp[1][1] = 0;

    for (int ai : a) {
      int[][] nextDp = new int[2][2];
      for (int i = 0; i < nextDp.length; ++i) {
        Arrays.fill(nextDp[i], Integer.MAX_VALUE);
      }

      for (int i = 0; i < dp.length; ++i) {
        for (int j = 0; j < dp[i].length; ++j) {
          if (dp[i][j] != Integer.MAX_VALUE) {
            if (i == 0) {
              if (j == 0) {
                nextDp[0][1] = Math.min(nextDp[0][1], dp[0][0] + ((ai == 1) ? 1 : 0));
              }

              nextDp[1][0] = Math.min(nextDp[1][0], dp[0][j]);
            } else {
              if (j == 0) {
                nextDp[1][1] = Math.min(nextDp[1][1], dp[1][0]);
              }

              nextDp[0][0] = Math.min(nextDp[0][0], dp[1][j] + ((ai == 1) ? 1 : 0));
            }
          }
        }
      }

      dp = nextDp;
    }

    return Arrays.stream(dp).mapToInt(x -> Arrays.stream(x).min().getAsInt()).min().getAsInt();
  }
}
