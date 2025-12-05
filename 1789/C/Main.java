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
      int[] p = new int[m];
      int[] v = new int[m];
      for (int i = 0; i < m; ++i) {
        p[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(a, p, v));
    }

    sc.close();
  }

  static long solve(int[] a, int[] p, int[] v) {
    int m = p.length;

    Map<Integer, Integer> valueToBeginIndex = new HashMap<>();
    for (int ai : a) {
      valueToBeginIndex.put(ai, 0);
    }

    Map<Integer, Integer> valueToShowNums = new HashMap<>();
    for (int i = 0; i < m; ++i) {
      valueToShowNums.put(
          a[p[i] - 1],
          valueToShowNums.getOrDefault(a[p[i] - 1], 0)
              + (i + 1 - valueToBeginIndex.get(a[p[i] - 1])));
      valueToBeginIndex.put(v[i], i + 1);

      a[p[i] - 1] = v[i];
    }

    for (int ai : a) {
      valueToShowNums.put(
          ai, valueToShowNums.getOrDefault(ai, 0) + (m + 1 - valueToBeginIndex.get(ai)));
    }

    return valueToShowNums.values().stream()
        .mapToLong(showNum -> showNum * (showNum - 1L) / 2 + showNum * (m + 1L - showNum))
        .sum();
  }
}