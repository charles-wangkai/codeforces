import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] grid = new int[n][n];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < n; ++c) {
          grid[r][c] = line.charAt(c) - '0';
        }
      }

      System.out.println(solve(grid));
    }

    sc.close();
  }

  static int solve(int[][] grid) {
    int n = grid.length;

    int result = 0;
    for (int r = 0, beginC = 0, endC = n - 2; beginC <= endC; ++r, ++beginC, --endC) {
      for (int c = beginC; c <= endC; ++c) {
        int oneCount =
            grid[r][c] + grid[c][n - 1 - r] + grid[n - 1 - r][n - 1 - c] + grid[n - 1 - c][r];

        result += Math.min(oneCount, 4 - oneCount);
      }
    }

    return result;
  }
}