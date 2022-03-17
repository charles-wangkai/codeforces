import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    System.out.println(solve(s1, s2) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String s1, String s2) {
    Map<Character, Integer> letterToCount1 = buildLetterToCount(s1);
    Map<Character, Integer> letterToCount2 = buildLetterToCount(s2);

    return letterToCount2.keySet().stream()
        .allMatch(
            letter2 -> letterToCount2.get(letter2) <= letterToCount1.getOrDefault(letter2, 0));
  }

  static Map<Character, Integer> buildLetterToCount(String s) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (c != ' ') {
        letterToCount.put(c, letterToCount.getOrDefault(c, 0) + 1);
      }
    }

    return letterToCount;
  }
}