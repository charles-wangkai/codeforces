import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(n, a, b) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int n, int a, int b) {
    return (a == n && b == n) || a + b <= n - 2;
  }
}
