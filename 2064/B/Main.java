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

  static String solve(int[] a) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    int beginIndex = -1;
    int endIndex = -1;
    int start = 0;
    for (int i = 0; i < a.length; ++i) {
      if (valueToCount.get(a[i]) == 1) {
        if (beginIndex == -1 || i - start > endIndex - beginIndex) {
          beginIndex = start;
          endIndex = i;
        }
      } else {
        start = i + 1;
      }
    }

    return (beginIndex == -1) ? "0" : "%d %d".formatted(beginIndex + 1, endIndex + 1);
  }
}