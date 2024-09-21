import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(n, x, y));
    }

    sc.close();
  }

  static int solve(int n, int x, int y) {
    return Math.max((n + x - 1) / x, (n + y - 1) / y);
  }
}