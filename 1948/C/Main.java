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

      System.out.println(solve(grid) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(char[][] grid) {
    int n = grid[0].length;

    int r = 0;
    int c = 0;
    while (r != 1 || c != n - 1) {
      if (grid[r][c + 1] == '>') {
        c += 2;
      } else if (grid[1 - r][c] == '>') {
        r = 1 - r;
        ++c;
      } else {
        return false;
      }
    }

    return true;
  }
}