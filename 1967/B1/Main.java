import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static int solve(int n, int m) {
    int result = 0;
    for (int b = 1; b <= m; ++b) {
      for (int a = b; a <= n; a += b) {
        if ((a + b) % ((long) b * b) == 0) {
          ++result;
        }
      }
    }

    return result;
  }
}