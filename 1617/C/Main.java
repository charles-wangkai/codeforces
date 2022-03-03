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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    SortedMap<Integer, Integer> valueToCount = new TreeMap<>();
    for (int value : a) {
      updateMap(valueToCount, value, 1);
    }

    boolean[] rests = new boolean[a.length];
    for (int i = 0; i < rests.length; ++i) {
      if (valueToCount.containsKey(i + 1)) {
        updateMap(valueToCount, i + 1, -1);
      } else {
        rests[i] = true;
      }
    }

    int result = 0;
    for (int i = 0; i < rests.length; ++i) {
      if (rests[i]) {
        int first = valueToCount.firstKey();
        if (first <= (i + 1) * 2) {
          return -1;
        }

        updateMap(valueToCount, first, -1);
        ++result;
      }
    }

    return result;
  }

  static void updateMap(SortedMap<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}