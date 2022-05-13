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

    for (int c = 0; c < m; ++c) {
      for (int r = n - 1; r >= 0; --r) {
        int currentR = r;
        while (currentR + 1 != n && grid[currentR][c] == '*' && grid[currentR + 1][c] == '.') {
          grid[currentR][c] = '.';
          grid[currentR + 1][c] = '*';

          ++currentR;
        }
      }
    }

    return Arrays.stream(grid).map(String::new).collect(Collectors.joining("\n"));
  }
}