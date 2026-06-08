import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int bi : b) {
      valueToCount.put(bi, valueToCount.getOrDefault(bi, 0) + 1);
    }

    for (int i = 0; i < b.length; ++i) {
      for (int j = 0; j < b.length; ++j) {
        if (j != i && check(b.length, valueToCount, b[i], b[j])) {
          return "%d %d".formatted(b[i], b[j]);
        }
      }
    }

    return "-1";
  }

  static boolean check(int n, Map<Integer, Integer> valueToCount, int x, int y) {
    if (x < y) {
      return false;
    }

    Map<Integer, Integer> valueToFreq = new HashMap<>();

    valueToFreq.put(x, valueToFreq.getOrDefault(x, 0) + 1);
    if (valueToFreq.get(x) > valueToCount.getOrDefault(x, 0)) {
      return false;
    }

    valueToFreq.put(y, valueToFreq.getOrDefault(y, 0) + 1);
    if (valueToFreq.get(y) > valueToCount.getOrDefault(y, 0)) {
      return false;
    }

    for (int i = 0; i < n - 2; ++i) {
      int next = x % y;

      valueToFreq.put(next, valueToFreq.getOrDefault(next, 0) + 1);
      if (valueToFreq.get(next) > valueToCount.getOrDefault(next, 0)) {
        return false;
      }

      x = y;
      y = next;
    }

    return true;
  }
}