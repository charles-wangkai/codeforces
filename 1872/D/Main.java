import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(n, x, y));
    }

    sc.close();
  }

  static long solve(int n, int x, int y) {
    int posNum = n / x - (int) (n / lcm(x, y));
    int negNum = n / y - (int) (n / lcm(x, y));

    return (n + (n - posNum + 1L)) * posNum / 2 - (1L + negNum) * negNum / 2;
  }

  static long lcm(int x, int y) {
    return (long) x / gcd(x, y) * y;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
