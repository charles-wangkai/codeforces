import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, String t, int k) {
    return buildLetterToCount(s).equals(buildLetterToCount(t))
        && IntStream.range(0, s.length())
            .allMatch(i -> i >= k || i + k < s.length() || s.charAt(i) == t.charAt(i));
  }

  static Map<Character, Integer> buildLetterToCount(String str) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : str.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    return letterToCount;
  }
}
