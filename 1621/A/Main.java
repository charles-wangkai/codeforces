import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    if ((n + 1) / 2 < k) {
      return "-1";
    }

    char[][] board = new char[n][n];
    for (int r = 0; r < board.length; ++r) {
      Arrays.fill(board[r], '.');
    }
    for (int i = 0; i < k; ++i) {
      board[i * 2][i * 2] = 'R';
    }

    return Arrays.stream(board).map(String::new).collect(Collectors.joining("\n"));
  }
}
