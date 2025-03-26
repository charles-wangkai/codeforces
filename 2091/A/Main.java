import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final Map<Integer, Integer> DIGIT_TO_TARGET_COUNT =
      Map.ofEntries(entry(0, 3), entry(1, 1), entry(2, 2), entry(3, 1), entry(5, 1));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    Map<Integer, Integer> digitToCount = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      digitToCount.put(a[i], digitToCount.getOrDefault(a[i], 0) + 1);
      if (DIGIT_TO_TARGET_COUNT.keySet().stream()
          .allMatch(
              digit -> digitToCount.getOrDefault(digit, 0) >= DIGIT_TO_TARGET_COUNT.get(digit))) {
        return i + 1;
      }
    }

    return 0;
  }
}