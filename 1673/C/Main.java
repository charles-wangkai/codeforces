import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 40000;
  static final int MODULUS = 1_000_000_007;

  static int[] dp;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static void precompute() {
    int[] palindromes =
        IntStream.rangeClosed(1, LIMIT)
            .filter(
                x ->
                    Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString())
                        == x)
            .toArray();

    dp = new int[LIMIT + 1];
    dp[0] = 1;
    for (int palindrome : palindromes) {
      for (int i = palindrome; i < dp.length; ++i) {
        dp[i] = addMod(dp[i], dp[i - palindrome]);
      }
    }
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int solve(int n) {
    return dp[n];
  }
}
