import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, m, k));
    }

    sc.close();
  }

  static String solve(int n, int m, int k) {
    if (n >= m && k >= n - m && k <= n) {
      return "0".repeat(k) + "10".repeat(n - k) + "1".repeat(k - (n - m));
    }
    if (m >= n && k >= m - n && k <= m) {
      return "1".repeat(k) + "01".repeat(m - k) + "0".repeat(k - (m - n));
    }

    return "-1";
  }
}