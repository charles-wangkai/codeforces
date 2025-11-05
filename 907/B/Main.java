import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] table = new char[9][9];
    String s = null;
    for (int r = 0; r < 9; ++r) {
      for (int c = 0; c < 9; ++c) {
        if (c % 3 == 0) {
          s = sc.next();
        }

        table[r][c] = s.charAt(c % 3);
      }
    }
    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(table, x, y));

    sc.close();
  }

  static String solve(char[][] table, int x, int y) {
    int blockR = (x - 1) % 3;
    int blockC = (y - 1) % 3;

    int freeCount = 0;
    for (int dr = 0; dr < 3; ++dr) {
      for (int dc = 0; dc < 3; ++dc) {
        if (table[blockR * 3 + dr][blockC * 3 + dc] == '.') {
          table[blockR * 3 + dr][blockC * 3 + dc] = '!';
          ++freeCount;
        }
      }
    }

    if (freeCount == 0) {
      for (int r = 0; r < 9; ++r) {
        for (int c = 0; c < 9; ++c) {
          if (table[r][c] == '.') {
            table[r][c] = '!';
          }
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (int r = 0; r < 9; ++r) {
      if (r != 0 && r % 3 == 0) {
        result.append("\n");
      }

      for (int c = 0; c < 9; ++c) {
        if (c != 0 && c % 3 == 0) {
          result.append(" ");
        }

        result.append(table[r][c]);
      }
      result.append("\n");
    }

    return result.toString();
  }
}