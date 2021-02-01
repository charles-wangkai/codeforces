import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[k];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[k];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    Map<Integer, Integer> aValueToCount = buildValueToCount(a);
    Map<Integer, Integer> bValueToCount = buildValueToCount(b);

    long result = 0;
    for (int i = 0; i < a.length; ++i) {
      result += a.length - 1 - (aValueToCount.get(a[i]) - 1) - (bValueToCount.get(b[i]) - 1);
    }
    result /= 2;

    return result;
  }

  static Map<Integer, Integer> buildValueToCount(int[] values) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : values) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return valueToCount;
  }
}
