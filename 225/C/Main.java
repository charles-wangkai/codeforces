import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
    char[][] pixels = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        pixels[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(pixels, x, y));

    sc.close();
  }

  static int solve(char[][] pixels, int x, int y) {
    int n = pixels.length;
    int m = pixels[0].length;

    int[] whiteCounts = new int[m];
    for (char[] line : pixels) {
      for (int c = 0; c < line.length; ++c) {
        if (line[c] == '.') {
          ++whiteCounts[c];
        }
      }
    }

    Map<State, Integer> stateToFlipNum = Map.of(new State(false, 0), 0);
    for (int whiteCount : whiteCounts) {
      Map<State, Integer> nextStateToFlipNum = new HashMap<>();
      for (State state : stateToFlipNum.keySet()) {
        {
          State nextState = null;
          if (state.width() == 0) {
            nextState = new State(false, 1);
          } else if (!state.whiteOrBlack()) {
            nextState = new State(false, state.width() + 1);
          } else if (state.width() >= x && state.width() <= y) {
            nextState = new State(false, 1);
          }

          if (nextState != null) {
            nextStateToFlipNum.put(
                nextState,
                Math.min(
                    nextStateToFlipNum.getOrDefault(nextState, Integer.MAX_VALUE),
                    stateToFlipNum.get(state) + whiteCount));
          }
        }

        {
          State nextState = null;
          if (state.width() == 0) {
            nextState = new State(true, 1);
          } else if (state.whiteOrBlack()) {
            nextState = new State(true, state.width() + 1);
          } else if (state.width() >= x && state.width() <= y) {
            nextState = new State(true, 1);
          }

          if (nextState != null) {
            nextStateToFlipNum.put(
                nextState,
                Math.min(
                    nextStateToFlipNum.getOrDefault(nextState, Integer.MAX_VALUE),
                    stateToFlipNum.get(state) + (n - whiteCount)));
          }
        }
      }

      stateToFlipNum = nextStateToFlipNum;
    }

    return stateToFlipNum.keySet().stream()
        .filter(state -> state.width() >= x && state.width() <= y)
        .mapToInt(stateToFlipNum::get)
        .min()
        .getAsInt();
  }
}

record State(boolean whiteOrBlack, int width) {}
