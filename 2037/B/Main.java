import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      int[] a = new int[k];
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

    for (int i = 0; ; ++i) {
      if ((a.length - 2) % a[i] == 0) {
        int other = (a.length - 2) / a[i];
        if ((other == a[i] && valueToCount.getOrDefault(a[i], 0) >= 2)
            || (other != a[i]
                && valueToCount.containsKey(a[i])
                && valueToCount.containsKey(other))) {
          return "%d %d".formatted(a[i], other);
        }
      }
    }
  }
}