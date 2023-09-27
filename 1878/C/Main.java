import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      long x = sc.nextLong();

      System.out.println(solve(n, k, x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int k, long x) {
    return x >= k * (k + 1L) / 2 && x <= k * (n + (n - k + 1L)) / 2;
  }
}
