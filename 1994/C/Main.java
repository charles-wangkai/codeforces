import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static long solve(int[] a, int x) {
    int n = a.length;

    int[] nextIndices = new int[n];
    int sum = 0;
    int endIndex = -1;
    for (int i = 0; i < nextIndices.length; ++i) {
      while (endIndex != n - 1 && sum <= x) {
        ++endIndex;
        sum += a[endIndex];
      }

      nextIndices[i] = (endIndex == n - 1 && sum <= x) ? -1 : (endIndex + 1);

      sum -= a[i];
    }

    int[] dp = new int[n];
    for (int i = dp.length - 1; i >= 0; --i) {
      if (nextIndices[i] != -1) {
        dp[i] = 1 + ((nextIndices[i] == n) ? 0 : dp[nextIndices[i]]);
      }
    }

    return n * (n + 1L) / 2 - Arrays.stream(dp).asLongStream().sum();
  }
}