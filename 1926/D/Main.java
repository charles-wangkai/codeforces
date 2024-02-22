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
    Map<Integer, Integer> evenToCount = new HashMap<>();
    for (int ai : a) {
      if (ai % 2 == 0) {
        updateMap(evenToCount, ai, 1);
      }
    }

    int result = 0;
    for (int ai : a) {
      if (ai % 2 == 1) {
        int other = (int) ((1L << 31) - 1 - ai);
        if (evenToCount.containsKey(other)) {
          updateMap(evenToCount, other, -1);
        }

        ++result;
      }
    }
    result += evenToCount.values().stream().mapToInt(Integer::intValue).sum();

    return result;
  }

  static void updateMap(Map<Integer, Integer> map, int key, int delta) {
    map.put(key, map.getOrDefault(key, 0) + delta);
    map.remove(key, 0);
  }
}