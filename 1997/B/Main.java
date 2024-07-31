import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      char[][] grid = new char[2][n];
      for (int r = 0; r < grid.length; ++r) {
        String line = sc.next();
        for (int c = 0; c < n; ++c) {
          grid[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(grid));
    }

    sc.close();
  }

  static int solve(char[][] grid) {
    int result = 0;
    for (int r = 0; r < grid.length; ++r) {
      for (int c = 1; c < grid[r].length - 1; ++c) {
        if (grid[r][c] == '.'
            && grid[r][c - 1] == '.'
            && grid[r][c + 1] == '.'
            && grid[(r + 1) % 2][c] == '.'
            && grid[(r + 1) % 2][c - 1] == 'x'
            && grid[(r + 1) % 2][c + 1] == 'x') {
          ++result;
        }
      }
    }

    return result;
  }
}