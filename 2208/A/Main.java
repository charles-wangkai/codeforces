import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] a = new int[n][n];
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < n; ++c) {
          a[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[][] a) {
    int n = a.length;

    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        valueToCount.put(a[r][c], valueToCount.getOrDefault(a[r][c], 0) + 1);
      }
    }

    return valueToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt() <= n * n - n;
  }
}