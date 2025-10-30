import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

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

    sc.close();
  }

  static String solve(int[] a, int[] b, int k) {
    int[] maxWorks = IntStream.range(0, a.length).map(i -> a[i] / b[i]).toArray();

    long[] suffixSums = new long[maxWorks.length];
    for (int i = suffixSums.length - 1; i >= 0; --i) {
      suffixSums[i] = ((i == suffixSums.length - 1) ? 0 : suffixSums[i + 1]) + maxWorks[i];
    }

    int[] result = new int[maxWorks.length];
    for (int i = 0; i < result.length; ++i) {
      long needed = Math.max(0, k - ((i == result.length - 1) ? 0 : suffixSums[i + 1]));
      if (needed <= maxWorks[i]) {
        result[i] = (int) needed;
        k -= needed;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}