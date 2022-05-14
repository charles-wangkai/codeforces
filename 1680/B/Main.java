import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char[][] cells = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          cells[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(cells) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(char[][] cells) {
    int n = cells.length;
    int m = cells[0].length;

    int minR = Integer.MAX_VALUE;
    int minC = Integer.MAX_VALUE;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (cells[r][c] == 'R') {
          minR = Math.min(minR, r);
          minC = Math.min(minC, c);
        }
      }
    }

    return cells[minR][minC] == 'R';
  }
}