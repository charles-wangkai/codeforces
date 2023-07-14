import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      char[][] cells = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          cells[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(cells, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(char[][] cells, int k) {
    int n = cells.length;
    int m = cells[0].length;

    boolean[][] covered = new boolean[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        int maxD = findMaxD(cells, r, c);
        if (maxD >= k) {
          for (int h = 0; h <= maxD; ++h) {
            covered[r - h][c - h] = true;
            covered[r - h][c + h] = true;
          }
        }
      }
    }

    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (cells[r][c] == '*' && !covered[r][c]) {
          return false;
        }
      }
    }

    return true;
  }

  static int findMaxD(char[][] cells, int centerR, int centerC) {
    int m = cells[0].length;

    int maxD = -1;
    while (maxD + 1 <= centerR
        && maxD + 1 <= centerC
        && centerC + (maxD + 1) < m
        && cells[centerR - (maxD + 1)][centerC - (maxD + 1)] == '*'
        && cells[centerR - (maxD + 1)][centerC + (maxD + 1)] == '*') {
      ++maxD;
    }

    return maxD;
  }
}
