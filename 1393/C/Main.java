import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
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
    for (int value : a) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    int maxCount = valueToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();

    return (int) valueToCount.values().stream().filter(count -> count == maxCount).count()
        - 1
        + valueToCount.values().stream()
                .filter(count -> count != maxCount)
                .mapToInt(Integer::intValue)
                .sum()
            / (maxCount - 1);
  }
}
