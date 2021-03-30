import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static long solve(long n) {
    while (gcd(n, computeDigitSum(n)) == 1) {
      ++n;
    }

    return n;
  }

  static int computeDigitSum(long n) {
    return String.valueOf(n).chars().map(ch -> ch - '0').sum();
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
