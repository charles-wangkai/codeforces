import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static String solve(int[] a, int k) {
    int minLength = Integer.MAX_VALUE;
    int l = -1;
    int r = -1;
    int endIndex = -1;
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int beginIndex = 0; beginIndex < a.length; ++beginIndex) {
      while (endIndex != a.length - 1 && valueToCount.size() != k) {
        ++endIndex;
        updateMap(valueToCount, a[endIndex], 1);
      }

      if (valueToCount.size() == k && endIndex - beginIndex + 1 < minLength) {
        minLength = endIndex - beginIndex + 1;
        l = beginIndex + 1;
        r = endIndex + 1;
      }

      updateMap(valueToCount, a[beginIndex], -1);
    }

    return "%d %d".formatted(l, r);
  }

  static void updateMap(Map<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}