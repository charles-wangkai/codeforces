import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int p = sc.nextInt();
      int q = sc.nextInt();

      System.out.println(solve(n, m, p, q) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int m, int p, int q) {
    return n % p != 0 || n / p * q == m;
  }
}