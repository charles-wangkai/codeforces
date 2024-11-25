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
    @SuppressWarnings("unchecked")
    Map<Character, Integer>[] letterToCountMaps = new Map[2];
    for (int i = 0; i < letterToCountMaps.length; ++i) {
      letterToCountMaps[i] = new HashMap<>();
    }

    for (int i = 0; i < s.length(); ++i) {
      updateMap(letterToCountMaps[i % 2], s.charAt(i), 1);
    }

    if (s.length() % 2 == 0) {
      return computeOperationNum(s.length(), letterToCountMaps);
    }

    int result = Integer.MAX_VALUE;
    for (int i = s.length() - 1; i >= 0; --i) {
      updateMap(letterToCountMaps[i % 2], s.charAt(i), -1);

      result = Math.min(result, 1 + computeOperationNum(s.length() - 1, letterToCountMaps));

      updateMap(letterToCountMaps[1 - i % 2], s.charAt(i), 1);
    }

    return result;
  }

  static int computeOperationNum(int length, Map<Character, Integer>[] letterToCountMaps) {
    return computeOperationNumForHalf(length / 2, letterToCountMaps[0])
        + computeOperationNumForHalf(length / 2, letterToCountMaps[1]);
  }

  static int computeOperationNumForHalf(int halfLength, Map<Character, Integer> letterToCount) {
    return halfLength - letterToCount.values().stream().mapToInt(Integer::intValue).max().orElse(0);
  }

  static void updateMap(Map<Character, Integer> letterToCount, char letter, int delta) {
    letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + delta);
  }
}