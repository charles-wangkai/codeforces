import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int p = sc.nextInt();
    int q = sc.nextInt();

    System.out.println(solve(n, a, b, p, q));

    sc.close();
  }

  static long solve(int n, int a, int b, int p, int q) {
    long common = n / lcm(a, b);

    return (n / a - common) * p + (n / b - common) * q + common * Math.max(p, q);
  }

  static long lcm(int x, int y) {
    return (long) x / gcd(x, y) * y;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}