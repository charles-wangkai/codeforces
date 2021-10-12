import java.util.Scanner;
import java.util.stream.IntStream;

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

    return !IntStream.range(1, n - 1).anyMatch(c -> grid[0][c] == '1' && grid[1][c] == '1');
  }
}
