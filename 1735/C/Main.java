import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      sc.nextInt();
      String t = sc.next();

      System.out.println(solve(t));
    }

    sc.close();
  }

  static String solve(String t) {
    Map<Character, Character> letterToPrev = new HashMap<>();
    Map<Character, Character> letterToNext = new HashMap<>();

    StringBuilder result = new StringBuilder();
    for (char letter : t.toCharArray()) {
      if (!letterToPrev.containsKey(letter)) {
        char tail = letter;
        while (letterToNext.containsKey(tail)) {
          tail = letterToNext.get(tail);
        }

        for (char prev = 'a'; ; ++prev) {
          if (!letterToNext.containsKey(prev) && (letterToPrev.size() == 25 || prev != tail)) {
            letterToPrev.put(letter, prev);
            letterToNext.put(prev, letter);

            break;
          }
        }
      }

      result.append(letterToPrev.get(letter));
    }

    return result.toString();
  }
}