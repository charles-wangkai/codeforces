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
    int n = grid.length;
    int m = grid[0].length;

    boolean[][] leftZeros = new boolean[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        leftZeros[r][c] = (c != 0 && leftZeros[r][c - 1]) || grid[r][c] == '0';
      }
    }

    boolean[][] upZeros = new boolean[n][m];
    for (int c = 0; c < m; ++c) {
      for (int r = 0; r < n; ++r) {
        upZeros[r][c] = (r != 0 && upZeros[r - 1][c]) || grid[r][c] == '0';
      }
    }

    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (grid[r][c] == '1' && leftZeros[r][c] && upZeros[r][c]) {
          return false;
        }
      }
    }

    return true;
  }
}