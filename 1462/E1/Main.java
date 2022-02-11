import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

  static long solve(int[] a) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : a) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return valueToCount.keySet().stream()
        .mapToLong(
            value ->
                valueToCount.get(value)
                        * (valueToCount.get(value) - 1L)
                        * (valueToCount.get(value) - 2)
                        / 6
                    + valueToCount.get(value)
                        * (valueToCount.get(value) - 1L)
                        / 2
                        * (valueToCount.getOrDefault(value + 1, 0))
                    + valueToCount.getOrDefault(value + 1, 0)
                        * (valueToCount.getOrDefault(value + 1, 0) - 1L)
                        / 2
                        * (valueToCount.get(value))
                    + valueToCount.get(value)
                        * (valueToCount.get(value) - 1L)
                        / 2
                        * (valueToCount.getOrDefault(value + 2, 0))
                    + valueToCount.getOrDefault(value + 2, 0)
                        * (valueToCount.getOrDefault(value + 2, 0) - 1L)
                        / 2
                        * (valueToCount.get(value))
                    + (long) valueToCount.get(value)
                        * valueToCount.getOrDefault(value + 1, 0)
                        * valueToCount.getOrDefault(value + 2, 0))
        .sum();
  }
}