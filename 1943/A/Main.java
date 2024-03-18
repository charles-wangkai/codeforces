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

    int result = 0;
    while (valueToCount.getOrDefault(result, 0) >= 2) {
      ++result;
    }
    if (valueToCount.containsKey(result)) {
      ++result;
    }
    while (valueToCount.getOrDefault(result, 0) >= 2) {
      ++result;
    }

    return result;
  }
}