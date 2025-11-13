import java.util.Arrays;
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
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    Arrays.sort(a);

    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    return IntStream.rangeClosed(1, a[a.length - 1])
        .filter(g -> isPossible(a, k, valueToCount, g))
        .max()
        .getAsInt();
  }

  static boolean isPossible(int[] a, int k, Map<Integer, Integer> valueToCount, int g) {
    int result = -1;
    int lower = 0;
    int upper = a.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (a[middle] < 4 * g) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result
            + 1
            - valueToCount.getOrDefault(g, 0)
            - valueToCount.getOrDefault(2 * g, 0)
            - valueToCount.getOrDefault(3 * g, 0)
        <= k;
  }
}