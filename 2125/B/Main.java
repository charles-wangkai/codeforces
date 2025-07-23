import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      long k = sc.nextLong();

      System.out.println(solve(a, b, k));
    }

    sc.close();
  }

  static int solve(long a, long b, long k) {
    long g = gcd(a, b);

    return (Math.max(a / g, b / g) <= k) ? 1 : 2;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}