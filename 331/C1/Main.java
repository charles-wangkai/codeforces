import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i < dp.length; ++i) {
      int rest = i;
      while (rest != 0) {
        int digit = rest % 10;
        if (digit != 0) {
          dp[i] = Math.min(dp[i], dp[i - digit] + 1);
        }

        rest /= 10;
      }
    }

    return dp[dp.length - 1];
  }
}