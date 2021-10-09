import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    long[] a = new long[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextLong();
    }
    long[] b = new long[m];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextLong();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(long[] a, long[] b) {
    if (a.length == 1) {
      return Arrays.stream(b)
          .mapToObj(bi -> String.valueOf(a[0] + bi))
          .collect(Collectors.joining(" "));
    }

    long g =
        IntStream.range(0, a.length - 1)
            .mapToLong(i -> Math.abs(a[i + 1] - a[i]))
            .reduce(Main::gcd)
            .getAsLong();

    return Arrays.stream(b)
        .mapToObj(bi -> String.valueOf(gcd(g, a[0] + bi)))
        .collect(Collectors.joining(" "));
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
