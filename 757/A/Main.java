import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    Map<Character, Integer> letterToCount = buildLetterToCount(s);

    return buildLetterToCount("Bulbasaur").entrySet().stream()
        .mapToInt(entry -> letterToCount.getOrDefault(entry.getKey(), 0) / entry.getValue())
        .min()
        .getAsInt();
  }

  static Map<Character, Integer> buildLetterToCount(String str) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : str.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }
    return letterToCount;
  }
}
