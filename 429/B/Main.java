import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] a = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        a[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static long solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    long[][] topLeftDistances = buildTopLeftDistances(a);
    long[][] topRightDistances = buildTopRightDistances(a);
    long[][] bottomLeftDistances = buildBottomLeftDistances(a);
    long[][] bottomRightDistances = buildBottomRightDistances(a);

    long result = -1;
    for (int r = 1; r <= n - 2; ++r) {
      for (int c = 1; c <= m - 2; ++c) {
        result =
            Math.max(
                result,
                Math.max(
                    topLeftDistances[r - 1][c]
                        + bottomRightDistances[r + 1][c]
                        + bottomLeftDistances[r][c - 1]
                        + topRightDistances[r][c + 1],
                    topLeftDistances[r][c - 1]
                        + bottomRightDistances[r][c + 1]
                        + bottomLeftDistances[r + 1][c]
                        + topRightDistances[r - 1][c]));
      }
    }

    return result;
  }

  static long[][] buildTopLeftDistances(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    long[][] result = new long[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        result[r][c] =
            Math.max((r == 0) ? 0 : result[r - 1][c], (c == 0) ? 0 : result[r][c - 1]) + a[r][c];
      }
    }

    return result;
  }

  static long[][] buildTopRightDistances(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    long[][] result = new long[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = m - 1; c >= 0; --c) {
        result[r][c] =
            Math.max((r == 0) ? 0 : result[r - 1][c], (c == m - 1) ? 0 : result[r][c + 1])
                + a[r][c];
      }
    }

    return result;
  }

  static long[][] buildBottomLeftDistances(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    long[][] result = new long[n][m];
    for (int r = n - 1; r >= 0; --r) {
      for (int c = 0; c < m; ++c) {
        result[r][c] =
            Math.max((r == n - 1) ? 0 : result[r + 1][c], (c == 0) ? 0 : result[r][c - 1])
                + a[r][c];
      }
    }

    return result;
  }

  static long[][] buildBottomRightDistances(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    long[][] result = new long[n][m];
    for (int r = n - 1; r >= 0; --r) {
      for (int c = m - 1; c >= 0; --c) {
        result[r][c] =
            Math.max((r == n - 1) ? 0 : result[r + 1][c], (c == m - 1) ? 0 : result[r][c + 1])
                + a[r][c];
      }
    }

    return result;
  }
}