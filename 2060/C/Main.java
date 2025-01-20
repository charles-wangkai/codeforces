import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x, k));
    }

    sc.close();
  }

  static int solve(int[] x, int k) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : x) {
      updateMap(valueToCount, value, 1);
    }

    int result = 0;
    for (int value : x) {
      if (valueToCount.containsKey(value)) {
        updateMap(valueToCount, value, -1);

        int other = k - value;
        if (valueToCount.containsKey(other)) {
          updateMap(valueToCount, other, -1);
          ++result;
        }
      }
    }

    return result;
  }

  static void updateMap(Map<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}