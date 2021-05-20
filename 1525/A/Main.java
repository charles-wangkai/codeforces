import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();

      System.out.println(solve(k));
    }

    sc.close();
  }

  static int solve(int k) {
    return 100 / gcd(k, 100);
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
