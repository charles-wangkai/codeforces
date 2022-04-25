import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(long n) {
    int result = (int) (2 * n % MODULUS);
    long lcm = 1;
    for (int i = 2; ; ++i) {
      lcm = computeLcm(lcm, i);
      if (lcm > n) {
        break;
      }

      result = Math.floorMod(result + n / lcm, MODULUS);
    }

    return result;
  }

  static long computeLcm(long x, long y) {
    return x / gcd(x, y) * y;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}