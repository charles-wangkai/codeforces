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
    int[] dp = new int[a.length + 1];
    for (int i = dp.length - 2; i >= 0; --i) {
      dp[i] =
          Math.min(
              (i + a[i] + 1 < dp.length) ? dp[i + a[i] + 1] : Integer.MAX_VALUE, dp[i + 1] + 1);
    }

    return dp[0];
  }
}