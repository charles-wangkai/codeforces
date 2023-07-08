import java.util.Scanner;

public class Main {
  static final int SIZE = 3;
  static final char[] TARGETS = {'X', 'O', '+'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      char[][] cells = new char[SIZE][SIZE];
      for (int r = 0; r < SIZE; ++r) {
        String line = sc.next();
        for (int c = 0; c < SIZE; ++c) {
          cells[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(cells));
    }

    sc.close();
  }

  static String solve(char[][] cells) {
    for (char target : TARGETS) {
      if (isWinner(cells, target)) {
        return String.valueOf(target);
      }
    }

    return "DRAW";
  }

  static boolean isWinner(char[][] cells, char target) {
    return (cells[0][0] == target && cells[0][1] == target && cells[0][2] == target)
        || (cells[1][0] == target && cells[1][1] == target && cells[1][2] == target)
        || (cells[2][0] == target && cells[2][1] == target && cells[2][2] == target)
        || (cells[0][0] == target && cells[1][0] == target && cells[2][0] == target)
        || (cells[0][1] == target && cells[1][1] == target && cells[2][1] == target)
        || (cells[0][2] == target && cells[1][2] == target && cells[2][2] == target)
        || (cells[0][0] == target && cells[1][1] == target && cells[2][2] == target)
        || (cells[0][2] == target && cells[1][1] == target && cells[2][0] == target);
  }
}
