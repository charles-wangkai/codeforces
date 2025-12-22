import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final char[][][] BISHWOCKS = {
    {{'.', '.'}, {'.', '.'}},
    {{'X', 'X'}, {'X', '.'}},
    {{'X', 'X'}, {'.', 'X'}},
    {{'.', 'X'}, {'X', 'X'}},
    {{'X', '.'}, {'X', 'X'}}
  };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] board = new String[2];
    for (int i = 0; i < board.length; ++i) {
      board[i] = sc.next();
    }

    System.out.println(solve(board));

    sc.close();
  }

  static int solve(String[] board) {
    int n = board[0].length();

    Map<String, Integer> stateToBishwockNum = Map.of("XX", 0);
    for (int c = 0; c < n; ++c) {
      Map<String, Integer> nextStateToBishwockNum = new HashMap<>();
      for (String state : stateToBishwockNum.keySet()) {
        char[][] box =
            new char[][] {
              {state.charAt(0), board[0].charAt(c)}, {state.charAt(1), board[1].charAt(c)}
            };
        for (char[][] bishwock : BISHWOCKS) {
          String nextState = put(box, bishwock);
          if (nextState != null) {
            nextStateToBishwockNum.put(
                nextState,
                Math.max(
                    nextStateToBishwockNum.getOrDefault(nextState, 0),
                    stateToBishwockNum.get(state) + (isDummyBishwock(bishwock) ? 0 : 1)));
          }
        }
      }

      stateToBishwockNum = nextStateToBishwockNum;
    }

    return stateToBishwockNum.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }

  static boolean isDummyBishwock(char[][] bishwock) {
    for (int r = 0; r < 2; ++r) {
      for (int c = 0; c < 2; ++c) {
        if (bishwock[r][c] != '.') {
          return false;
        }
      }
    }

    return true;
  }

  static String put(char[][] box, char[][] bishwock) {
    for (int r = 0; r < 2; ++r) {
      for (int c = 0; c < 2; ++c) {
        if (bishwock[r][c] == 'X' && box[r][c] == 'X') {
          return null;
        }
      }
    }

    return "%c%c"
        .formatted(
            (box[0][1] == 'X' || bishwock[0][1] == 'X') ? 'X' : '0',
            (box[1][1] == 'X' || bishwock[1][1] == 'X') ? 'X' : '0');
  }
}