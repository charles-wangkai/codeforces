import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int h = sc.nextInt();
      int w = sc.nextInt();

      System.out.println(solve(h, w));
    }

    sc.close();
  }

  static String solve(int h, int w) {
    char[][] cells = new char[h][w];
    for (int r = 0; r < h; ++r) {
      Arrays.fill(cells[r], '0');
    }

    for (int c = 0; c < w; ++c) {
      if (check(cells, 0, c)) {
        cells[0][c] = '1';
      }
    }
    for (int r = 0; r < h; ++r) {
      if (check(cells, r, w - 1)) {
        cells[r][w - 1] = '1';
      }
    }
    for (int c = w - 1; c >= 0; --c) {
      if (check(cells, h - 1, c)) {
        cells[h - 1][c] = '1';
      }
    }
    for (int r = h - 1; r >= 0; --r) {
      if (check(cells, r, 0)) {
        cells[r][0] = '1';
      }
    }

    return Arrays.stream(cells).map(String::new).collect(Collectors.joining("\n"));
  }

  static boolean check(char[][] cells, int r, int c) {
    int m = cells.length;
    int n = cells[0].length;

    for (int dr = -1; dr <= 1; ++dr) {
      for (int dc = -1; dc <= 1; ++dc) {
        int adjR = r + dr;
        int adjC = c + dc;
        if (adjR >= 0 && adjR < m && adjC >= 0 && adjC < n && cells[adjR][adjC] == '1') {
          return false;
        }
      }
    }

    return true;
  }
}
