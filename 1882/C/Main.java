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

  static long solve(int[] a) {
    long[] suffixMaxSums = new long[a.length];
    for (int i = suffixMaxSums.length - 1; i >= 0; --i) {
      suffixMaxSums[i] =
          ((i == suffixMaxSums.length - 1) ? 0 : suffixMaxSums[i + 1]) + Math.max(0, a[i]);
    }

    return Math.max(
        0,
        IntStream.range(0, a.length)
            .mapToLong(
                i -> ((i % 2 == 0) ? a[i] : 0) + ((i == a.length - 1) ? 0 : suffixMaxSums[i + 1]))
            .max()
            .getAsLong());
  }
}