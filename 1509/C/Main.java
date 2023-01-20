import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] s = new int[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.nextInt();
    }

    System.out.println(solve(s));

    sc.close();
  }

  static long solve(int[] s) {
    Arrays.sort(s);

    long[][] dp = new long[s.length][s.length];
    for (int length = 2; length <= s.length; ++length) {
      for (int beginIndex = 0; beginIndex + length - 1 < s.length; ++beginIndex) {
        int endIndex = beginIndex + length - 1;
        dp[beginIndex][endIndex] =
            Math.min(dp[beginIndex + 1][endIndex], dp[beginIndex][endIndex - 1])
                + (s[endIndex] - s[beginIndex]);
      }
    }

    return dp[0][s.length - 1];
  }
}
