import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, m, k));

    sc.close();
  }

  static long solve(int n, int m, int k) {
    long[] dp =
        IntStream.range(0, 1 << m)
            .map(i -> (Integer.bitCount(i) >= k) ? 1 : 0)
            .asLongStream()
            .toArray();
    for (int i = 0; i < n - m; ++i) {
      long[] nextDp = new long[dp.length];
      for (int j = 0; j < dp.length; ++j) {
        for (int d = 0; d <= 1; ++d) {
          int next = (j * 2 + d) % dp.length;
          if (Integer.bitCount(next) >= k) {
            nextDp[next] += dp[j];
          }
        }
      }

      dp = nextDp;
    }

    return Arrays.stream(dp).sum();
  }
}