import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static int solve(int[] a, int x) {
    SortedMap<Integer, Integer> valueToCount = new TreeMap<>();
    for (int value : a) {
      update(valueToCount, value, 1);
    }

    int result = 0;
    while (!valueToCount.isEmpty()) {
      int value = valueToCount.firstKey();
      update(valueToCount, value, -1);

      if ((long) value * x <= Integer.MAX_VALUE && valueToCount.containsKey(value * x)) {
        update(valueToCount, value * x, -1);
      } else {
        ++result;
      }
    }

    return result;
  }

  static void update(SortedMap<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}