import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int d = sc.nextInt();
      int[][] a = new int[n][m];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a, k, d));
    }

    sc.close();
  }

  static long solve(int[][] a, int k, int d) {
    long[] costs = Arrays.stream(a).mapToLong(ai -> computeCost(ai, d)).toArray();

    long result = Long.MAX_VALUE;
    long sum = IntStream.range(0, k - 1).mapToLong(i -> costs[i]).sum();
    for (int i = k - 1; i < costs.length; ++i) {
      sum += costs[i];
      result = Math.min(result, sum);

      sum -= costs[i - k + 1];
    }

    return result;
  }

  static long computeCost(int[] depths, int d) {
    long[] dp = new long[depths.length];
    dp[0] = 1;
    SortedMap<Long, Integer> prevToCount = new TreeMap<>();
    updateMap(prevToCount, dp[0], 1);
    for (int i = 1; i < dp.length; ++i) {
      dp[i] = prevToCount.firstKey() + (depths[i] + 1);

      updateMap(prevToCount, dp[i], 1);
      if (i >= d + 1) {
        updateMap(prevToCount, dp[i - d - 1], -1);
      }
    }

    return dp[dp.length - 1];
  }

  static void updateMap(SortedMap<Long, Integer> prevToCount, long key, int delta) {
    prevToCount.put(key, prevToCount.getOrDefault(key, 0) + delta);
    prevToCount.remove(key, 0);
  }
}
