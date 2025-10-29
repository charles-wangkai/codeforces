import java.util.Arrays;
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

  static int solve(long[] a) {
    long g = Arrays.stream(a).reduce(Main::gcd).getAsLong();

    return IntStream.iterate(2, x -> x + 1).filter(x -> gcd(x, g) == 1).findFirst().getAsInt();
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}