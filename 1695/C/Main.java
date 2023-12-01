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
        for (int c = 0; c < m; ++c) {
          a[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    int[][] minOnes = new int[n][m];
    int[][] maxOnes = new int[n][m];
    minOnes[0][0] = (a[0][0] == 1) ? 1 : 0;
    maxOnes[0][0] = (a[0][0] == 1) ? 1 : 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (r != 0 || c != 0) {
          minOnes[r][c] =
              Math.min(
                  (r == 0) ? Integer.MAX_VALUE : (minOnes[r - 1][c] + ((a[r][c] == 1) ? 1 : 0)),
                  (c == 0) ? Integer.MAX_VALUE : (minOnes[r][c - 1] + ((a[r][c] == 1) ? 1 : 0)));
          maxOnes[r][c] =
              Math.max(
                  (r == 0) ? Integer.MIN_VALUE : (maxOnes[r - 1][c] + ((a[r][c] == 1) ? 1 : 0)),
                  (c == 0) ? Integer.MIN_VALUE : (maxOnes[r][c - 1] + ((a[r][c] == 1) ? 1 : 0)));
        }
      }
    }

    return (n + m - 1) % 2 == 0
        && (n + m - 1) / 2 >= minOnes[n - 1][m - 1]
        && (n + m - 1) / 2 <= maxOnes[n - 1][m - 1];
  }
}