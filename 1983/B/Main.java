import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] a = new int[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          a[r][c] = line.charAt(c) - '0';
        }
      }
      int[][] b = new int[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          b[r][c] = line.charAt(c) - '0';
        }
      }

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[][] a, int[][] b) {
    int n = a.length;
    int m = a[0].length;

    for (int r = 0; r < n - 1; ++r) {
      for (int c = 0; c < m - 1; ++c) {
        while (a[r][c] != b[r][c]) {
          a[r][c] = (a[r][c] + 1) % 3;
          a[r + 1][c + 1] = (a[r + 1][c + 1] + 1) % 3;
          a[r][c + 1] = (a[r][c + 1] + 2) % 3;
          a[r + 1][c] = (a[r + 1][c] + 2) % 3;
        }
      }
    }

    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (a[r][c] != b[r][c]) {
          return false;
        }
      }
    }

    return true;
  }
}