import java.util.Scanner;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int[][] dp = new int[a.length + 1][2];
    dp[0][0] = 1;

    for (int i = 1; i < dp.length; ++i) {
      int prevA = (i == 1) ? Integer.MIN_VALUE : a[i - 2];
      int prevB = (i == 1) ? Integer.MIN_VALUE : b[i - 2];
      int currA = a[i - 1];
      int currB = b[i - 1];

      if (currA >= prevA && currB >= prevB) {
        dp[i][0] = addMod(dp[i][0], dp[i - 1][0]);
        dp[i][1] = addMod(dp[i][1], dp[i - 1][1]);
      }
      if (currA >= prevB && currB >= prevA) {
        dp[i][0] = addMod(dp[i][0], dp[i - 1][1]);
        dp[i][1] = addMod(dp[i][1], dp[i - 1][0]);
      }
    }

    return addMod(dp[dp.length - 1][0], dp[dp.length - 1][1]);
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }
}