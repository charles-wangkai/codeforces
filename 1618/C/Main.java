import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long[] a = new long[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(long[] a) {
    long gEven =
        IntStream.range(0, a.length)
            .filter(i -> i % 2 == 0)
            .mapToLong(i -> a[i])
            .reduce(Main::gcd)
            .getAsLong();
    if (check(a, gEven)) {
      return gEven;
    }

    long gOdd =
        IntStream.range(0, a.length)
            .filter(i -> i % 2 != 0)
            .mapToLong(i -> a[i])
            .reduce(Main::gcd)
            .getAsLong();

    return check(a, gOdd) ? gOdd : 0;
  }

  static boolean check(long[] a, long d) {
    return IntStream.range(0, a.length - 1).allMatch(i -> (a[i] % d == 0) != (a[i + 1] % d == 0));
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
