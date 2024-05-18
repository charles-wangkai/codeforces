import java.util.Arrays;
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

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, int k) {
    int n = a.length;

    if (k <= n) {
      long maxSum = -1;
      long sum = IntStream.range(0, k - 1).map(i -> a[i]).asLongStream().sum();
      for (int endIndex = k - 1; endIndex < n; ++endIndex) {
        sum += a[endIndex];
        maxSum = Math.max(maxSum, sum);
        sum -= a[endIndex - k + 1];
      }

      return maxSum + k * (k - 1L) / 2;
    }

    return Arrays.stream(a).asLongStream().sum() + ((k - 1L) * n - n * (n - 1L) / 2);
  }
}