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
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    long result =
        valueToCount.values().stream().mapToLong(count -> count * (count - 1L) * (count - 2)).sum();
    for (int value : valueToCount.keySet()) {
      for (int i = 1; i * i <= value; ++i) {
        if (value % i == 0) {
          if (i != 1) {
            result +=
                (long) valueToCount.getOrDefault(value / i, 0)
                    * valueToCount.get(value)
                    * valueToCount.getOrDefault(value * i, 0);
          }
          if (i * i != value && (long) value * (value / i) <= Integer.MAX_VALUE) {
            result +=
                (long) valueToCount.getOrDefault(i, 0)
                    * valueToCount.get(value)
                    * valueToCount.getOrDefault(value * (value / i), 0);
          }
        }
      }
    }

    return result;
  }
}