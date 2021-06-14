import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

      System.out.println(solve(grid));
    }

    sc.close();
  }

  static String solve(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Boolean rEven = null;
    Boolean wEven = null;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (grid[r][c] == 'R') {
          boolean even = (r + c) % 2 == 0;
          if (rEven != null && rEven != even) {
            return "NO";
          }

          rEven = even;
        } else if (grid[r][c] == 'W') {
          boolean even = (r + c) % 2 == 0;
          if (wEven != null && wEven != even) {
            return "NO";
          }

          wEven = even;
        }
      }
    }
    if (rEven != null && rEven == wEven) {
      return "NO";
    }

    if (rEven == null) {
      if (wEven == null) {
        wEven = true;
      }

      rEven = !wEven;
    } else {
      wEven = !rEven;
    }

    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (grid[r][c] == '.') {
          if ((r + c) % 2 == 0) {
            grid[r][c] = rEven ? 'R' : 'W';
          } else {
            grid[r][c] = rEven ? 'W' : 'R';
          }
        }
      }
    }

    return String.format(
        "YES\n%s", Arrays.stream(grid).map(String::new).collect(Collectors.joining("\n")));
  }
}
