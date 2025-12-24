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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int[] prefixCostSums = new int[a.length];
    for (int i = 1; i < prefixCostSums.length; ++i) {
      prefixCostSums[i] = prefixCostSums[i - 1] + Math.abs(a[i] - a[i - 1]);
    }

    int[] suffixCostSums = new int[a.length];
    for (int i = suffixCostSums.length - 2; i >= 0; --i) {
      suffixCostSums[i] = suffixCostSums[i + 1] + Math.abs(a[i] - a[i + 1]);
    }

    return IntStream.range(0, a.length)
        .map(
            i ->
                ((i == 0) ? 0 : prefixCostSums[i - 1])
                    + ((i == 0 || i == a.length - 1) ? 0 : Math.abs(a[i - 1] - a[i + 1]))
                    + ((i == a.length - 1) ? 0 : suffixCostSums[i + 1]))
        .min()
        .getAsInt();
  }
}