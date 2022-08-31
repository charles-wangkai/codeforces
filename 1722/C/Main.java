import static java.util.Map.entry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final Map<Integer, Integer> COUNT_TO_POINT =
      Map.ofEntries(entry(1, 3), entry(2, 1), entry(3, 0));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String[][] words = new String[3][n];
      for (int i = 0; i < words.length; ++i) {
        for (int j = 0; j < words[i].length; ++j) {
          words[i][j] = sc.next();
        }
      }

      System.out.println(solve(words));
    }

    sc.close();
  }

  static String solve(String[][] words) {
    Map<String, Integer> wordToCount = new HashMap<>();
    for (int i = 0; i < words.length; ++i) {
      for (int j = 0; j < words[i].length; ++j) {
        wordToCount.put(words[i][j], wordToCount.getOrDefault(words[i][j], 0) + 1);
      }
    }

    return Arrays.stream(words)
        .mapToInt(
            p -> Arrays.stream(p).mapToInt(word -> COUNT_TO_POINT.get(wordToCount.get(word))).sum())
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}