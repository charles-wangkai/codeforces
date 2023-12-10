import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] b) {
    boolean[] dp = new boolean[b.length + 1];
    dp[0] = true;
    for (int i = 0; i < dp.length; ++i) {
      if (i != 0 && i - b[i - 1] - 1 >= 0 && dp[i - b[i - 1] - 1]) {
        dp[i] = true;
      }
      if (dp[i] && i != b.length && i + b[i] + 1 < dp.length) {
        dp[i + b[i] + 1] = true;
      }
    }

    return dp[dp.length - 1];
  }
}