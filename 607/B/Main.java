import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] c = new int[n];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }

    System.out.println(solve(c));

    sc.close();
  }

  static int solve(int[] c) {
    int[][] dp = new int[c.length][c.length];
    for (int i = 0; i < dp.length; ++i) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    for (int length = 1; length <= c.length; ++length) {
      for (int beginIndex = 0; beginIndex + length <= c.length; ++beginIndex) {
        int endIndex = beginIndex + length - 1;
        for (int i = beginIndex; i <= endIndex; ++i) {
          if (c[i] == c[beginIndex]) {
            dp[beginIndex][endIndex] =
                Math.min(
                    dp[beginIndex][endIndex],
                    Math.max(1, getValue(dp, beginIndex + 1, i - 1))
                        + getValue(dp, i + 1, endIndex));
          }
        }
      }
    }

    return dp[0][c.length - 1];
  }

  static int getValue(int[][] dp, int beginIndex, int endIndex) {
    return (beginIndex <= endIndex) ? dp[beginIndex][endIndex] : 0;
  }
}