import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, k));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int k) {
    Map<Integer, Integer> bValueToCount = new HashMap<>();
    for (int bValue : b) {
      bValueToCount.put(bValue, bValueToCount.getOrDefault(bValue, 0) + 1);
    }

    Map<Integer, Integer> aValueToCount = new HashMap<>();
    for (int i = 0; i < b.length - 1; ++i) {
      aValueToCount.put(a[i], aValueToCount.getOrDefault(a[i], 0) + 1);
    }

    int result = 0;
    int matchingNum =
        aValueToCount.keySet().stream()
            .mapToInt(
                aValue ->
                    Math.min(aValueToCount.get(aValue), bValueToCount.getOrDefault(aValue, 0)))
            .sum();
    for (int i = b.length - 1; i < a.length; ++i) {
      if (aValueToCount.getOrDefault(a[i], 0) < bValueToCount.getOrDefault(a[i], 0)) {
        ++matchingNum;
      }
      aValueToCount.put(a[i], aValueToCount.getOrDefault(a[i], 0) + 1);

      if (matchingNum >= k) {
        ++result;
      }

      if (aValueToCount.get(a[i - b.length + 1])
          <= bValueToCount.getOrDefault(a[i - b.length + 1], 0)) {
        --matchingNum;
      }
      aValueToCount.put(a[i - b.length + 1], aValueToCount.get(a[i - b.length + 1]) - 1);
    }

    return result;
  }
}