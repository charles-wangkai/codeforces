import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    int k = sc.nextInt();

    System.out.println(solve(s, k));

    sc.close();
  }

  static String solve(String s, int k) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : s.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    Character[] sortedLetters =
        letterToCount.keySet().stream()
            .sorted(Comparator.comparing(letterToCount::get))
            .toArray(Character[]::new);
    for (char letter : sortedLetters) {
      int delta = Math.min(k, letterToCount.get(letter));

      letterToCount.put(letter, letterToCount.get(letter) - delta);
      k -= delta;
    }

    StringBuilder removed = new StringBuilder();
    for (char letter : s.toCharArray()) {
      if (letterToCount.get(letter) != 0) {
        removed.append(letter);
        letterToCount.put(letter, letterToCount.get(letter) - 1);
      }
    }

    return "%d\n%s".formatted(removed.chars().distinct().count(), removed);
  }
}