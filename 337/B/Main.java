import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();

    System.out.println(solve(a, b, c, d));

    sc.close();
  }

  static String solve(int a, int b, int c, int d) {
    if (c * b < a * d) {
      return solve(b, a, d, c);
    }

    int numer = c * b - a * d;
    int denom = c * b;
    int g = gcd(numer, denom);

    return "%d/%d".formatted(numer / g, denom / g);
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}