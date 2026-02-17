import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long[] f = new long[n];
      for (int i = 0; i < f.length; ++i) {
        f[i] = sc.nextLong();
      }

      System.out.println(solve(f));
    }

    sc.close();
  }

  static String solve(long[] f) {
    int n = f.length;

    long[] prefixSums = new long[n + 1];
    prefixSums[n] = (f[0] + f[n - 1]) / (n - 1);
    for (int i = 1; i <= n - 1; ++i) {
      prefixSums[i] = (f[i] - f[i - 1] + prefixSums[n]) / 2;
    }

    return IntStream.rangeClosed(1, n)
        .map(i -> (int) (prefixSums[i] - prefixSums[i - 1]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}