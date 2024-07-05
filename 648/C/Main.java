import java.util.Scanner;

public class Main {
  static final char[] COMMANDS = {'U', 'R', 'D', 'L'};
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] cells = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        cells[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(cells));

    sc.close();
  }

  static String solve(char[][] cells) {
    int n = cells.length;
    int m = cells[0].length;

    Point start = findStart(cells);
    int r = start.r();
    int c = start.c();

    StringBuilder result = new StringBuilder();
    int prevR = -1;
    int prevC = -1;
    while (true) {
      for (int i = 0; i < COMMANDS.length; ++i) {
        int adjR = r + R_OFFSETS[i];
        int adjC = c + C_OFFSETS[i];
        if (adjR >= 0
            && adjR < n
            && adjC >= 0
            && adjC < m
            && cells[adjR][adjC] != '.'
            && !(adjR == prevR && adjC == prevC)) {
          result.append(COMMANDS[i]);
          prevR = r;
          prevC = c;
          r = adjR;
          c = adjC;

          break;
        }
      }

      if (cells[r][c] == 'S') {
        break;
      }
    }

    return result.toString();
  }

  static Point findStart(char[][] cells) {
    for (int r = 0; ; ++r) {
      for (int c = 0; c < cells[r].length; ++c) {
        if (cells[r][c] == 'S') {
          return new Point(r, c);
        }
      }
    }
  }
}

record Point(int r, int c) {}
