import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    int n = a.length;

    long[] prefixSums = new long[a.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + a[i - 1];
    }

    Arrays.sort(b);

    return IntStream.range(0, b.length)
            .mapToLong(
                i -> Math.abs(computeRangeSum(prefixSums, (i == 0) ? 0 : b[i - 1], b[i] - 1)))
            .sum()
        + ((b[b.length - 1] == n) ? 0 : computeRangeSum(prefixSums, b[b.length - 1], n - 1));
  }

  static long computeRangeSum(long[] prefixSums, int beginIndex, int endIndex) {
    return prefixSums[endIndex + 1] - prefixSums[beginIndex];
  }
}