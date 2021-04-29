import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, m, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int m, int k) {
    return n * m - 1 == k;
  }
}
