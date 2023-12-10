import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int p = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, p, k));
    }

    sc.close();
  }

  static int solve(int[] a, int p, int k) {
    Arrays.sort(a);

    int[] dp = new int[a.length + 1];
    for (int i = 1; i < dp.length; ++i) {
      dp[i] = Math.min(dp[i - 1], (i >= k) ? dp[i - k] : Integer.MAX_VALUE) + a[i - 1];
    }

    return IntStream.range(0, dp.length).filter(i -> dp[i] <= p).max().getAsInt();
  }
}