import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static long solve(int n) {
    return 4L * n / gcd(4L * n, n + 1) + 1;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}