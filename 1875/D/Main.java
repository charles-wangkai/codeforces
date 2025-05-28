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
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }
    if (!valueToCount.containsKey(0)) {
      return 0;
    }

    int max = -1;
    while (valueToCount.containsKey(max + 1)) {
      ++max;
    }

    int[][] cache = new int[max + 1][max + 2];
    for (int i = 0; i < cache.length; ++i) {
      Arrays.fill(cache[i], -1);
    }

    return search(cache, valueToCount, max, max + 1);
  }

  static int search(int[][] cache, Map<Integer, Integer> valueToCount, int value, int mex) {
    if (value == 0) {
      return (valueToCount.get(0) - 1) * mex;
    }

    if (cache[value][mex] == -1) {
      cache[value][mex] =
          Math.min(
              search(cache, valueToCount, value - 1, mex),
              (valueToCount.get(value) - 1) * mex
                  + value
                  + search(cache, valueToCount, value - 1, value));
    }

    return cache[value][mex];
  }
}
