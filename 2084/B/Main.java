import java.util.Arrays;
import java.util.Scanner;

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

      System.out.println(solve(a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(long[] a) {
    long min = Arrays.stream(a).min().getAsLong();
    long[] multiples = Arrays.stream(a).filter(x -> x % min == 0).sorted().skip(1).toArray();

    return multiples.length != 0 && Arrays.stream(multiples).reduce(Main::gcd).getAsLong() == min;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}