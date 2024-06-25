import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 0, 0, 1};
  static final int[] C_OFFSETS = {0, -1, 0, 1, 0};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    char[][] board = new char[n][n];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < n; ++c) {
        board[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(board) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(char[][] board) {
    int n = board.length;

    for (int r = 1; r < n - 1; ++r) {
      for (int c = 1; c < n - 1; ++c) {
        int r_ = r;
        int c_ = c;
        if (IntStream.range(0, R_OFFSETS.length)
            .allMatch(i -> board[r_ + R_OFFSETS[i]][c_ + C_OFFSETS[i]] == '#')) {
          for (int i = 0; i < R_OFFSETS.length; ++i) {
            board[r + R_OFFSETS[i]][c + C_OFFSETS[i]] = '.';
          }
        }
      }
    }

    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if (board[r][c] == '#') {
          return false;
        }
      }
    }

    return true;
  }
}