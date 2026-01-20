import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    int n = a.length;

    Map<Integer, Integer> aValueToCount = buildValueToCount(a);
    Map<Integer, Integer> bValueToCount = buildValueToCount(b);

    return n * (n - 1L) * (n - 2) / 6
        - IntStream.range(0, n)
            .mapToLong(i -> (aValueToCount.get(a[i]) - 1L) * (bValueToCount.get(b[i]) - 1))
            .sum();
  }

  static Map<Integer, Integer> buildValueToCount(int[] values) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : values) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return valueToCount;
  }
}