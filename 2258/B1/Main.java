import java.util.Arrays;
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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static int solve(int[] a, int m) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    Arrays.sort(a);

    int result = -1;
    int beginIndex = 0;
    for (int i = 1; i <= m; ++i) {
      while (beginIndex != a.length && a[beginIndex] < i) {
        ++beginIndex;
      }

      result = Math.max(result, a.length - beginIndex + valueToCount.getOrDefault(i * 2, 0));
    }

    return result;
  }
}