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
      int l = sc.nextInt();
      int r = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k, l, r));
    }

    sc.close();
  }

  static long solve(int[] a, int k, int l, int r) {
    int minEndIndex = -1;
    Map<Integer, Integer> valueToCountForMin = new HashMap<>();

    int maxEndIndex = -1;
    Map<Integer, Integer> valueToCountForMax = new HashMap<>();

    long result = 0;
    for (int beginIndex = 0; beginIndex < a.length; ++beginIndex) {
      while (valueToCountForMin.size() != k && minEndIndex != a.length - 1) {
        ++minEndIndex;
        updateMap(valueToCountForMin, a[minEndIndex], 1);
      }
      if (valueToCountForMin.size() != k) {
        break;
      }

      while (maxEndIndex != a.length - 1
          && (valueToCountForMax.size() != k
              || valueToCountForMax.containsKey(a[maxEndIndex + 1]))) {
        ++maxEndIndex;
        updateMap(valueToCountForMax, a[maxEndIndex], 1);
      }

      int minLength = Math.max(minEndIndex - beginIndex + 1, l);
      int maxLength = Math.min(maxEndIndex - beginIndex + 1, r);
      result += Math.max(0, maxLength - minLength + 1);

      updateMap(valueToCountForMin, a[beginIndex], -1);
      updateMap(valueToCountForMax, a[beginIndex], -1);
    }

    return result;
  }

  static void updateMap(Map<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}