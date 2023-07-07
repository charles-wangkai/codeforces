import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      sc.nextInt();
      sc.nextInt();
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, String t) {
    return buildLetterToCount(s).equals(buildLetterToCount(t))
        && (s.length() >= 6
            || (s.length() == 5 && s.charAt(2) == t.charAt(2))
            || (s.length() == 4 && s.charAt(1) == t.charAt(1) && s.charAt(2) == t.charAt(2))
            || s.equals(t));
  }

  static Map<Character, Integer> buildLetterToCount(String str) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : str.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    return letterToCount;
  }
}
