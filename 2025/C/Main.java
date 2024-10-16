import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    Arrays.sort(a);

    int result = -1;
    int endIndex = -1;
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int beginIndex = 0; beginIndex < a.length; ++beginIndex) {
      while (endIndex != a.length - 1
          && (endIndex == beginIndex - 1 || a[endIndex + 1] - a[endIndex] <= 1)
          && (valueToCount.size() != k || valueToCount.containsKey(a[endIndex + 1]))) {
        ++endIndex;
        updateMap(valueToCount, a[endIndex], 1);
      }

      result = Math.max(result, endIndex - beginIndex + 1);

      updateMap(valueToCount, a[beginIndex], -1);
    }

    return result;
  }

  static void updateMap(Map<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}