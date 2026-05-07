import java.util.Scanner;
import java.util.stream.IntStream;

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

      System.out.println(solve(a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    boolean[] dp = new boolean[a.length * 100 + 1];
    dp[0] = true;
    for (int ai : a) {
      int step = 100 / ai;
      for (int remainder = 0; remainder < step; ++remainder) {
        int remainder_ = remainder;
        int trueCount =
            (int)
                IntStream.rangeClosed(0, ai)
                    .filter(
                        j ->
                            dp.length - 1 - remainder_ - step * j >= 0
                                && dp[dp.length - 1 - remainder_ - step * j])
                    .count();

        int beginIndex = dp.length - 1 - remainder - step * ai;
        for (int lastIndex = dp.length - 1 - remainder; lastIndex >= 0; lastIndex -= step) {
          if (dp[lastIndex]) {
            --trueCount;
          }

          dp[lastIndex] |= trueCount != 0;

          beginIndex -= step;
          if (beginIndex >= 0 && dp[beginIndex]) {
            ++trueCount;
          }
        }
      }
    }

    return IntStream.range(0, dp.length).allMatch(i -> dp[i]);
  }
}