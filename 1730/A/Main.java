import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, c));
    }

    sc.close();
  }

  static int solve(int[] a, int c) {
    Map<Integer, Integer> orbitToCount = new HashMap<>();
    for (int ai : a) {
      orbitToCount.put(ai, orbitToCount.getOrDefault(ai, 0) + 1);
    }

    return orbitToCount.values().stream().mapToInt(count -> Math.min(c, count)).sum();
  }
}