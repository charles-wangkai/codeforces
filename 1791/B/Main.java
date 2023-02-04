import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;

public class Main {
  static final Map<Character, Integer> MOVE_TO_X_OFFSET =
      Map.ofEntries(entry('L', -1), entry('R', 1), entry('U', 0), entry('D', 0));
  static final Map<Character, Integer> MOVE_TO_Y_OFFSET =
      Map.ofEntries(entry('L', 0), entry('R', 0), entry('U', 1), entry('D', -1));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    int x = 0;
    int y = 0;
    for (char move : s.toCharArray()) {
      x += MOVE_TO_X_OFFSET.get(move);
      y += MOVE_TO_Y_OFFSET.get(move);

      if (x == 1 && y == 1) {
        return true;
      }
    }

    return false;
  }
}
