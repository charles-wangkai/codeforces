import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] a = new int[n][m];
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < m; ++c) {
          a[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    int maxValue = Integer.MIN_VALUE;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        maxValue = Math.max(maxValue, a[r][c]);
      }
    }

    Set<Point> points = new HashSet<>();
    Map<Integer, Integer> rToCount = new HashMap<>();
    Map<Integer, Integer> cToCount = new HashMap<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (a[r][c] == maxValue) {
          points.add(new Point(r, c));
          rToCount.put(r, rToCount.getOrDefault(r, 0) + 1);
          cToCount.put(c, cToCount.getOrDefault(c, 0) + 1);
        }
      }
    }

    for (int r : rToCount.keySet()) {
      for (int c : cToCount.keySet()) {
        if (rToCount.get(r) + cToCount.get(c) - (points.contains(new Point(r, c)) ? 1 : 0)
            == points.size()) {
          return maxValue - 1;
        }
      }
    }

    return maxValue;
  }
}

record Point(int r, int c) {}
