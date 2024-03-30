import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int d = sc.nextInt();

      System.out.println(solve(a, b, c, d));
    }

    sc.close();
  }

  static String solve(int a, int b, int c, int d) {
    for (int x = a + 1; x <= c; ++x) {
      long rest = (long) a * b / gcd((long) a * b, x);
      long y = (b + rest) / rest * rest;
      if (y <= d) {
        return String.format("%d %d", x, y);
      }
    }

    return "-1 -1";
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}