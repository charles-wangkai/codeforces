import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char[][] grid = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          grid[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(grid) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(char[][] grid) {
    return canFillAll(grid, 'W') || canFillAll(grid, 'B');
  }

  static boolean canFillAll(char[][] grid, char color) {
    int n = grid.length;
    int m = grid[0].length;

    int minR = Integer.MAX_VALUE;
    int maxR = Integer.MIN_VALUE;
    int minC = Integer.MAX_VALUE;
    int maxC = Integer.MIN_VALUE;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (grid[r][c] == color) {
          minR = Math.min(minR, r);
          maxR = Math.max(maxR, r);
          minC = Math.min(minC, c);
          maxC = Math.max(maxC, c);
        }
      }
    }

    return minR == 0 && maxR == n - 1 && minC == 0 && maxC == m - 1;
  }
}