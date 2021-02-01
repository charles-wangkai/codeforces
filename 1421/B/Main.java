import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      char[][] grid = new char[n][n];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < n; ++c) {
          grid[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(grid));
    }

    sc.close();
  }

  static String solve(char[][] grid) {
    List<String> inverted = new ArrayList<>();
    find(inverted, grid);

    return String.format(
        "%d%s%s", inverted.size(), inverted.isEmpty() ? "" : "\n", String.join("\n", inverted));
  }

  static void find(List<String> inverted, char[][] grid) {
    if (!check(grid)) {
      for (int r = 0; r <= 2; ++r) {
        for (int c = 0; r + c <= 2; ++c) {
          if (!(r == 0 && c == 0)) {
            invert(grid, r, c);
            if (check(grid)) {
              inverted.add(String.format("%d %d", r + 1, c + 1));

              return;
            }
            invert(grid, r, c);
          }
        }
      }

      for (int r1 = 0; ; ++r1) {
        for (int c1 = 0; r1 + c1 <= 2; ++c1) {
          for (int r2 = 0; r2 <= 2; ++r2) {
            for (int c2 = 0; r2 + c2 <= 2; ++c2) {
              if (!(r1 == 0 && c1 == 0) && !(r2 == 0 && c2 == 0) && !(r1 == r2 && c1 == c2)) {
                invert(grid, r1, c1);
                invert(grid, r2, c2);
                if (check(grid)) {
                  inverted.add(String.format("%d %d", r1 + 1, c1 + 1));
                  inverted.add(String.format("%d %d", r2 + 1, c2 + 1));

                  return;
                }
                invert(grid, r1, c1);
                invert(grid, r2, c2);
              }
            }
          }
        }
      }
    }
  }

  static void invert(char[][] grid, int r, int c) {
    grid[r][c] = (char) ('0' + '1' - grid[r][c]);
  }

  static boolean check(char[][] grid) {
    return grid[0][1] == grid[1][0]
        && grid[0][2] == grid[1][1]
        && grid[1][1] == grid[2][0]
        && grid[0][1] != grid[0][2];
  }
}
