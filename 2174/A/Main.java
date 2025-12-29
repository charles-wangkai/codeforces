import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t));
    }

    sc.close();
  }

  static String solve(String s, String t) {
    Map<Character, Integer> sLetterToCount = buildLetterToCount(s);
    Map<Character, Integer> tLetterToCount = buildLetterToCount(t);
    if (sLetterToCount.keySet().stream()
        .anyMatch(
            sLetter -> tLetterToCount.getOrDefault(sLetter, 0) < sLetterToCount.get(sLetter))) {
      return "Impossible";
    }

    String additional =
        tLetterToCount.keySet().stream()
            .sorted()
            .map(
                tLetter ->
                    String.valueOf(tLetter)
                        .repeat(
                            tLetterToCount.get(tLetter) - sLetterToCount.getOrDefault(tLetter, 0)))
            .collect(Collectors.joining());

    StringBuilder result = new StringBuilder();
    int sIndex = 0;
    int aIndex = 0;
    while (sIndex != s.length() || aIndex != additional.length()) {
      if (sIndex == s.length()
          || (aIndex != additional.length() && additional.charAt(aIndex) < s.charAt(sIndex))) {
        result.append(additional.charAt(aIndex));
        ++aIndex;
      } else {
        char firstLetter = s.charAt(sIndex);
        while (sIndex != s.length() && s.charAt(sIndex) <= firstLetter) {
          result.append(s.charAt(sIndex));
          ++sIndex;
        }
      }
    }

    return result.toString();
  }

  static Map<Character, Integer> buildLetterToCount(String str) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : str.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    return letterToCount;
  }
}