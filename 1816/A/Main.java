import java.util.Scanner;

public class Main {
  static final int LIMIT = 1_000_000_000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int a, int b) {
    int x1 = (a == LIMIT) ? (a - 1) : (a + 1);
    int y1 = 0;
    while (gcd(x1, y1) != 1) {
      ++y1;
    }

    return String.format("2\n%d %d\n%d %d", x1, y1, a, b);
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
