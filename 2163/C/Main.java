import java.util.Comparator;
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
      int[][] a = new int[2][n];
      for (int r = 0; r < a.length; ++r) {
        for (int c = 0; c < a[r].length; ++c) {
          a[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[][] a) {
    int n = a[0].length;

    int[] topLeftMins = new int[n];
    int[] topLeftMaxs = new int[n];
    for (int c = 0; c < n; ++c) {
      topLeftMins[c] = Math.min((c == 0) ? Integer.MAX_VALUE : topLeftMins[c - 1], a[0][c]);
      topLeftMaxs[c] = Math.max((c == 0) ? Integer.MIN_VALUE : topLeftMaxs[c - 1], a[0][c]);
    }

    int[] bottomRightMins = new int[n];
    int[] bottomRightMaxs = new int[n];
    for (int c = n - 1; c >= 0; --c) {
      bottomRightMins[c] =
          Math.min((c == n - 1) ? Integer.MAX_VALUE : bottomRightMins[c + 1], a[1][c]);
      bottomRightMaxs[c] =
          Math.max((c == n - 1) ? Integer.MIN_VALUE : bottomRightMaxs[c + 1], a[1][c]);
    }

    Range[] ranges =
        IntStream.range(0, n)
            .mapToObj(
                c ->
                    new Range(
                        Math.min(topLeftMins[c], bottomRightMins[c]),
                        Math.max(topLeftMaxs[c], bottomRightMaxs[c])))
            .sorted(Comparator.comparing(Range::min))
            .toArray(Range[]::new);

    SortedMap<Integer, Integer> maxToCount = new TreeMap<>();
    for (Range range : ranges) {
      updateMap(maxToCount, range.max(), 1);
    }

    long result = 0;
    int rangeIndex = 0;
    for (int i = 1; i <= 2 * n; ++i) {
      while (rangeIndex != ranges.length && ranges[rangeIndex].min() < i) {
        updateMap(maxToCount, ranges[rangeIndex].max(), -1);
        ++rangeIndex;
      }

      if (!maxToCount.isEmpty()) {
        result += 2 * n - maxToCount.firstKey() + 1;
      }
    }

    return result;
  }

  static void updateMap(SortedMap<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}

record Range(int min, int max) {}
