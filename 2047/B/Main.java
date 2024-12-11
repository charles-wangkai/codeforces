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

  static String solve(String s) {
    if (s.chars().distinct().count() == 1) {
      return s;
    }

    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : s.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    char to = letterToCount.keySet().stream().max(Comparator.comparing(letterToCount::get)).get();
    char from =
        letterToCount.keySet().stream()
            .filter(letter -> letter != to)
            .min(Comparator.comparing(letterToCount::get))
            .get();

    char[] result = s.toCharArray();
    for (int i = 0; ; ++i) {
      if (result[i] == from) {
        result[i] = to;

        break;
      }
    }

    return new String(result);
  }
}