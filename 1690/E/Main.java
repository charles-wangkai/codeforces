import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

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

  static long solve(int[] a, int k) {
    long result = 0;
    NavigableMap<Integer, Integer> valueToCount = new TreeMap<>();
    for (int ai : a) {
      result += ai / k;

      int remainder = ai % k;
      if (remainder != 0) {
        valueToCount.put(remainder, valueToCount.getOrDefault(remainder, 0) + 1);
      }
    }

    while (!valueToCount.isEmpty()) {
      int maxValue = valueToCount.lastKey();
      update(valueToCount, maxValue, -1);

      if (valueToCount.isEmpty()) {
        break;
      }

      Integer otherValue = valueToCount.ceilingKey(k - maxValue);
      if (otherValue == null) {
        break;
      }

      update(valueToCount, otherValue, -1);
      ++result;
    }

    return result;
  }

  static void update(NavigableMap<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}