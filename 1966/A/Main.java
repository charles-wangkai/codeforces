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
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c, k));
    }

    sc.close();
  }

  static int solve(int[] c, int k) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ci : c) {
      valueToCount.put(ci, valueToCount.getOrDefault(ci, 0) + 1);
    }

    return (valueToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt() >= k)
        ? (k - 1)
        : c.length;
  }
}