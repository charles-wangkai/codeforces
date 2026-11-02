import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      sc.nextInt();
      String p = sc.next();
      String q = sc.next();

      System.out.println(solve(p, q) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String p, String q) {
    return buildLetterToCount(p).equals(buildLetterToCount(q + "six"));
  }

  static Map<Character, Integer> buildLetterToCount(String s) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : s.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    return letterToCount;
  }
}