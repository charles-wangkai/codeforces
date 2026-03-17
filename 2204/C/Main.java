import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      long m = sc.nextLong();

      System.out.println(solve(a, b, c, m));
    }

    sc.close();
  }

  static String solve(int a, int b, int c, long m) {
    return "%d %d %d"
        .formatted(
            computeCollectedWater(m, a, b, c),
            computeCollectedWater(m, b, c, a),
            computeCollectedWater(m, c, a, b));
  }

  static long computeCollectedWater(long m, int interval1, int interval2, int interval3) {
    long num1 = m / interval1;
    long num12 = m / lcm(interval1, interval2);
    long num13 = m / lcm(interval1, interval3);
    long num123 = m / lcm(lcm(interval1, interval2), interval3);

    return num123 * 2 + (num12 + num13 - 2 * num123) * 3 + (num1 - num12 - num13 + num123) * 6;
  }

  static long lcm(long x, long y) {
    return x / gcd(x, y) * y;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}