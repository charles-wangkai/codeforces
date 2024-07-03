import java.util.Comparator;
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
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : s.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }
    if (s.length() % 2 == 1
        || letterToCount.values().stream().anyMatch(count -> count * 2 > s.length())) {
      return -1;
    }

    Map<Character, Integer> sameLetterToCount = new HashMap<>();
    for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
      if (s.charAt(i) == s.charAt(j)) {
        updateMap(sameLetterToCount, s.charAt(i), 1);
      }
    }

    int result = 0;
    while (sameLetterToCount.size() >= 2) {
      Character[] sameLetters =
          sameLetterToCount.keySet().stream()
              .sorted(Comparator.comparing(sameLetterToCount::get).reversed())
              .toArray(Character[]::new);
      updateMap(sameLetterToCount, sameLetters[0], -1);
      updateMap(sameLetterToCount, sameLetters[1], -1);
      ++result;
    }
    if (sameLetterToCount.size() == 1) {
      result += sameLetterToCount.values().iterator().next();
    }

    return result;
  }

  static void updateMap(Map<Character, Integer> sameLetterToCount, char sameLetter, int delta) {
    sameLetterToCount.put(sameLetter, sameLetterToCount.getOrDefault(sameLetter, 0) + delta);
    sameLetterToCount.remove(sameLetter, 0);
  }
}