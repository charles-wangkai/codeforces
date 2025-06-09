import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      updateMap(valueToCount, ai, 1);
    }

    int result = 0;
    int index = a.length - 1;
    while (!valueToCount.isEmpty()) {
      int valueNum = valueToCount.size();
      Set<Integer> seen = new HashSet<>();
      while (true) {
        updateMap(valueToCount, a[index], -1);
        seen.add(a[index]);
        --index;

        if (seen.size() == valueNum) {
          break;
        }
      }

      ++result;
    }

    return result;
  }

  static void updateMap(Map<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}