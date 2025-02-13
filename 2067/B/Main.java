import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    SortedMap<Integer, Integer> valueToCount = new TreeMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    while (!valueToCount.isEmpty()) {
      int minValue = valueToCount.firstKey();
      if (valueToCount.get(minValue) == 1) {
        return false;
      }
      if (valueToCount.get(minValue) != 2) {
        valueToCount.put(
            minValue + 1,
            valueToCount.getOrDefault(minValue + 1, 0) + (valueToCount.get(minValue) - 2));
      }
      valueToCount.remove(minValue);
    }

    return true;
  }
}