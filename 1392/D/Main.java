import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final char[] DIRECTIONS = {'L', 'R'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    Map<Integer, Integer> dp = new HashMap<>();
    for (char first1 : DIRECTIONS) {
      for (char first2 : DIRECTIONS) {
        dp.put(
            encode(first1, first2, first1, first2),
            ((first1 == s.charAt(0)) ? 0 : 1) + ((first2 == s.charAt(1)) ? 0 : 1));
      }
    }

    for (int i = 2; i < s.length(); ++i) {
      Map<Integer, Integer> nextDp = new HashMap<>();
      for (int state : dp.keySet()) {
        for (char direction : DIRECTIONS) {
          if (isLogical(decodeLast2(state), decodeLast1(state), direction)) {
            int nextState =
                encode(decodeFirst1(state), decodeFirst2(state), decodeLast1(state), direction);
            nextDp.put(
                nextState,
                Math.min(
                    nextDp.getOrDefault(nextState, Integer.MAX_VALUE),
                    dp.get(state) + ((direction == s.charAt(i)) ? 0 : 1)));
          }
        }
      }

      dp = nextDp;
    }

    return dp.keySet().stream()
        .filter(
            state ->
                isLogical(decodeLast2(state), decodeLast1(state), decodeFirst1(state))
                    && isLogical(decodeLast1(state), decodeFirst1(state), decodeFirst2(state)))
        .mapToInt(dp::get)
        .min()
        .getAsInt();
  }

  static boolean isLogical(char direction1, char direction2, char direction3) {
    return (direction1 == 'L' && direction3 == 'R')
        || (direction1 == 'R' && direction3 == 'L')
        || (direction1 == 'R' && direction3 == 'R' && direction2 == 'L')
        || (direction1 == 'L' && direction3 == 'L' && direction2 == 'R');
  }

  static int encode(char first1, char first2, char last2, char last1) {
    return (toValue(first1) << 3) + (toValue(first2) << 2) + (toValue(last2) << 1) + toValue(last1);
  }

  static char decodeFirst1(int state) {
    return toDirection((state >> 3) & 1);
  }

  static char decodeFirst2(int state) {
    return toDirection((state >> 2) & 1);
  }

  static char decodeLast2(int state) {
    return toDirection((state >> 1) & 1);
  }

  static char decodeLast1(int state) {
    return toDirection(state & 1);
  }

  static int toValue(char direction) {
    return (direction == 'L') ? 0 : 1;
  }

  static char toDirection(int value) {
    return (value == 0) ? 'L' : 'R';
  }
}
