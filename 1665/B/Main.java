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
    if (Arrays.stream(a).distinct().count() == 1) {
      return 0;
    }

    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : a) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    int result = 1;
    int current = valueToCount.values().stream().mapToInt(x -> x).max().getAsInt();
    while (true) {
      int delta = Math.min(a.length - current, current);
      result += delta;
      current += delta;
      if (current == a.length) {
        break;
      }

      ++result;
    }

    return result;
  }
}