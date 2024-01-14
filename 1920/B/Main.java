import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k, x));
    }

    sc.close();
  }

  static int solve(int[] a, int k, int x) {
    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int result = Integer.MIN_VALUE;
    int total = Arrays.stream(sorted).sum();
    int maxSum = IntStream.range(0, x).map(i -> sorted[i]).sum();
    for (int i = 0; i <= k; ++i) {
      result = Math.max(result, total - 2 * maxSum);

      if (i < a.length) {
        total -= sorted[i];

        maxSum -= sorted[i];
        if (i + x < a.length) {
          maxSum += sorted[i + x];
        }
      }
    }

    return result;
  }
}