import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(n, m, a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int m, int a, int b) {
    return gcd(n, a) == 1 && gcd(m, b) == 1 && gcd(n, m) <= 2;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}