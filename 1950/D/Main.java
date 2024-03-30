import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 100000;

  static boolean[] dp;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n) ? "YES" : "NO");
    }

    sc.close();
  }

  static void precompute() {
    int[] binaries =
        IntStream.rangeClosed(2, LIMIT)
            .filter(x -> String.valueOf(x).chars().allMatch(c -> c == '0' || c == '1'))
            .toArray();

    dp = new boolean[LIMIT + 1];
    dp[1] = true;
    for (int i = 1; i < dp.length; ++i) {
      if (dp[i]) {
        for (int binary : binaries) {
          if (i * binary >= dp.length) {
            break;
          }

          dp[i * binary] = true;
        }
      }
    }
  }

  static boolean solve(int n) {
    return dp[n];
  }
}