import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int w = sc.nextInt();
    int h = sc.nextInt();
    int d = sc.nextInt();
    int n = sc.nextInt();

    System.out.println(solve(w, h, d, n));

    sc.close();
  }

  static String solve(int w, int h, int d, int n) {
    int gw = gcd(n, w);
    int wc = gw - 1;
    n /= gw;

    int gh = gcd(n, h);
    int hc = gh - 1;
    n /= gh;

    int gd = gcd(n, d);
    int dc = gd - 1;
    n /= gd;

    return (n == 1) ? "%d %d %d".formatted(wc, hc, dc) : "-1";
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}