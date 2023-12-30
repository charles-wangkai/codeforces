import java.util.Scanner;

public class Main {
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

  static int solve(int a, int b) {
    int g = gcd(a, b);
    a /= g;
    b /= g;

    return b * ((a == 1) ? b : a) * g;
  }

  static int gcd(int a, int b) {
    return (b == 0) ? a : gcd(b, a % b);
  }
}