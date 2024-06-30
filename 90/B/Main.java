import java.util.Scanner;

public class Main {
  static final int ALPHABET_SIZE = 26;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

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

    sc.close();
  }

  static String solve(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] rowCounts = new int[n][ALPHABET_SIZE];
    int[][] colCounts = new int[m][ALPHABET_SIZE];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        ++rowCounts[r][grid[r][c] - 'a'];
        ++colCounts[c][grid[r][c] - 'a'];
      }
    }

    boolean[][] crossed = new boolean[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (rowCounts[r][grid[r][c] - 'a'] != 1 || colCounts[c][grid[r][c] - 'a'] != 1) {
          crossed[r][c] = true;
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (!crossed[r][c]) {
          result.append(grid[r][c]);
        }
      }
    }

    return result.toString();
  }
}