import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        st = new StringTokenizer(br.readLine());
        x[i] = Integer.parseInt(st.nextToken());
        y[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(x, y));
    }
  }

  static long solve(int[] x, int[] y) {
    int n = x.length;

    if (n == 1) {
      return 1;
    }

    SortedMap<Integer, Integer> xToCount = new TreeMap<>();
    SortedMap<Integer, Integer> yToCount = new TreeMap<>();
    for (int i = 0; i < n; ++i) {
      updateMap(xToCount, x[i], 1);
      updateMap(yToCount, y[i], 1);
    }

    long result = Long.MAX_VALUE;
    for (int i = 0; i < n; ++i) {
      updateMap(xToCount, x[i], -1);
      updateMap(yToCount, y[i], -1);

      int xSide = xToCount.lastKey() - xToCount.firstKey() + 1;
      int ySide = yToCount.lastKey() - yToCount.firstKey() + 1;

      long cost = (long) xSide * ySide;
      if (cost == n - 1) {
        cost += Math.min(xSide, ySide);
      }

      result = Math.min(result, cost);

      updateMap(xToCount, x[i], 1);
      updateMap(yToCount, y[i], 1);
    }

    return result;
  }

  static void updateMap(SortedMap<Integer, Integer> map, int key, int delta) {
    map.put(key, map.getOrDefault(key, 0) + delta);
    map.remove(key, 0);
  }
}