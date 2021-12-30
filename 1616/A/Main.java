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
    Map<Integer, Integer> absToCount = new HashMap<>();
    for (int ai : a) {
      absToCount.put(Math.abs(ai), absToCount.getOrDefault(Math.abs(ai), 0) + 1);
    }

    return absToCount.keySet().stream()
        .mapToInt(abs -> Math.min((abs == 0) ? 1 : 2, absToCount.get(abs)))
        .sum();
  }
}
