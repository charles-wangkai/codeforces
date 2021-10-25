import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char[][] matrix = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          matrix[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(matrix));
    }

    sc.close();
  }

  static int solve(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int[][] leftCounts = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        leftCounts[r][c] = (matrix[r][c] == '*') ? (1 + ((c != 0) ? leftCounts[r][c - 1] : 0)) : 0;
      }
    }

    int[][] rightCounts = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = m - 1; c >= 0; --c) {
        rightCounts[r][c] =
            (matrix[r][c] == '*') ? (1 + ((c != m - 1) ? rightCounts[r][c + 1] : 0)) : 0;
      }
    }

    int result = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        for (int i = 0; r + i < n; ++i) {
          if (leftCounts[r + i][c] < i + 1 || rightCounts[r + i][c] < i + 1) {
            break;
          }

          ++result;
        }
      }
    }

    return result;
  }
}
