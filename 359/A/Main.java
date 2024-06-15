import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] cells = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        cells[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(cells));

    sc.close();
  }

  static int solve(int[][] cells) {
    int n = cells.length;
    int m = cells[0].length;

    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (cells[r][c] == 1 && (r == 0 || r == n - 1 || c == 0 || c == m - 1)) {
          return 2;
        }
      }
    }

    return 4;
  }
}