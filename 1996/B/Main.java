import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      char[][] grid = new char[n][n];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < n; ++c) {
          grid[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(grid, k));
    }

    sc.close();
  }

  static String solve(char[][] grid, int k) {
    int n = grid.length;

    char[][] result = new char[n / k][n / k];
    for (int r = 0; r < n / k; ++r) {
      for (int c = 0; c < n / k; ++c) {
        result[r][c] = grid[r * k][c * k];
      }
    }

    return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
  }
}