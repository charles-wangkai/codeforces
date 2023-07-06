import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int m) {
    return n == 1 || computeMinFactor(n) > m;
  }

  static int computeMinFactor(int n) {
    for (int i = 2; i * i <= n; ++i) {
      if (n % i == 0) {
        return i;
      }
    }

    return n;
  }
}
