import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c));
    }

    sc.close();
  }

  static int solve(int[] c) {
    Map<Integer, Integer> colorToCount = new HashMap<>();
    for (int color : c) {
      colorToCount.put(color, colorToCount.getOrDefault(color, 0) + 1);
    }

    int[] sorted =
        Arrays.stream(c)
            .boxed()
            .sorted(
                Comparator.<Integer, Integer>comparing(colorToCount::get)
                    .thenComparing(color -> color))
            .mapToInt(Integer::intValue)
            .toArray();

    int result = 0;
    for (int i = 0; i < sorted.length; i += 2) {
      if (i == 0 || sorted[i] != sorted[i - 2]) {
        ++result;

        if (colorToCount.get(sorted[i]) == 1) {
          ++result;
        }
      }
    }

    return result;
  }
}