import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, k));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b, int k) {
    int n = a.length;

    long maxSubarraySum = computeMaxSubarraySum(a);

    if (k % 2 == 0) {
      return maxSubarraySum;
    }

    long[] leftMaxSums = new long[n];
    for (int i = 0; i < leftMaxSums.length; ++i) {
      leftMaxSums[i] = Math.max(0, ((i == 0) ? 0 : leftMaxSums[i - 1]) + a[i]);
    }

    long[] rightMaxSums = new long[n];
    for (int i = rightMaxSums.length - 1; i >= 0; --i) {
      rightMaxSums[i] =
          Math.max(0, ((i == rightMaxSums.length - 1) ? 0 : rightMaxSums[i + 1]) + a[i]);
    }

    return Math.max(
        maxSubarraySum,
        IntStream.range(0, n)
            .mapToLong(
                i ->
                    (long) a[i]
                        + b[i]
                        + ((i == 0) ? 0 : leftMaxSums[i - 1])
                        + ((i == n - 1) ? 0 : rightMaxSums[i + 1]))
            .max()
            .getAsLong());
  }

  static long computeMaxSubarraySum(int[] values) {
    long result = Long.MIN_VALUE;
    long sum = 0;
    for (int value : values) {
      sum += value;
      result = Math.max(result, sum);
      sum = Math.max(0, sum);
    }

    return result;
  }
}