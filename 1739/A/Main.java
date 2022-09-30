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

  static String solve(int n, int m) {
    for (int r = 1; r <= n; ++r) {
      for (int c = 1; c <= m; ++c) {
        if (isIsolated(n, m, r, c)) {
          return String.format("%d %d", r, c);
        }
      }
    }

    return "1 1";
  }

  static boolean isIsolated(int n, int m, int r, int c) {
    for (int dr = -2; dr <= 2; ++dr) {
      for (int dc = -2; dc <= 2; ++dc) {
        if (Math.abs(dr * dc) == 2 && r + dr >= 1 && r + dr <= n && c + dc >= 1 && c + dc <= m) {
          return false;
        }
      }
    }

    return true;
  }
}
