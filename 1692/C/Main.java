import java.util.Scanner;

public class Main {
  static final int SIZE = 8;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      char[][] board = new char[SIZE][SIZE];
      for (int r = 0; r < SIZE; ++r) {
        String line = sc.next();
        for (int c = 0; c < SIZE; ++c) {
          board[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(board));
    }

    sc.close();
  }

  static String solve(char[][] board) {
    for (int r = 1; ; ++r) {
      for (int c = 1; c + 1 < SIZE; ++c) {
        if (board[r][c] == '#'
            && board[r - 1][c - 1] == '#'
            && board[r - 1][c + 1] == '#'
            && board[r + 1][c - 1] == '#'
            && board[r + 1][c + 1] == '#') {
          return String.format("%d %d", r + 1, c + 1);
        }
      }
    }
  }
}