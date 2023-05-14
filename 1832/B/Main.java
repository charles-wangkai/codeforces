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
    Arrays.sort(a);

    long[] leftSums = new long[a.length + 1];
    for (int i = 1; i < leftSums.length; ++i) {
      leftSums[i] = leftSums[i - 1] + a[i - 1];
    }

    long[] rightSums = new long[a.length + 1];
    for (int i = 1; i < rightSums.length; ++i) {
      rightSums[i] = rightSums[i - 1] + a[a.length - i];
    }

    long total = Arrays.stream(a).asLongStream().sum();

    return IntStream.rangeClosed(0, k)
        .mapToLong(rightNum -> total - leftSums[2 * (k - rightNum)] - rightSums[rightNum])
        .max()
        .getAsLong();
  }
}
