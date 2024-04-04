import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
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
    int result = Integer.MAX_VALUE;
    for (int i = 1; i * i <= s.length(); ++i) {
      if (s.length() % i == 0) {
        if (check(s, i)) {
          result = Math.min(result, i);
        }
        if (check(s, s.length() / i)) {
          result = Math.min(result, s.length() / i);
        }
      }
    }

    return result;
  }

  static boolean check(String s, int unitLength) {
    boolean diffFound = false;
    for (int i = 0; i < unitLength; ++i) {
      Map<Character, Integer> letterToCount = new HashMap<>();
      for (int j = 0; j < s.length() / unitLength; ++j) {
        char letter = s.charAt(j * unitLength + i);
        letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
      }

      if (letterToCount.size() > 2
          || (letterToCount.size() == 2
              && letterToCount.values().stream().allMatch(count -> count != 1))) {
        return false;
      }

      if (letterToCount.size() == 2) {
        if (diffFound) {
          return false;
        }

        diffFound = true;
      }
    }

    return true;
  }
}