import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int Ax = sc.nextInt();
      int Ay = sc.nextInt();
      int Bx = sc.nextInt();
      int By = sc.nextInt();
      int[] xs = new int[n];
      for (int i = 0; i < xs.length; ++i) {
        xs[i] = sc.nextInt();
      }
      int[] ys = new int[n];
      for (int i = 0; i < ys.length; ++i) {
        ys[i] = sc.nextInt();
      }

      System.out.println(solve(xs, ys, Ax, Ay, Bx, By));
    }

    sc.close();
  }

  static long solve(int[] xs, int[] ys, int Ax, int Ay, int Bx, int By) {
    Map<Integer, Integer> xToMinY = new HashMap<>();
    Map<Integer, Integer> xToMaxY = new HashMap<>();

    for (int i = 0; i < xs.length; ++i) {
      update(xToMinY, xToMaxY, xs[i], ys[i]);
    }
    update(xToMinY, xToMaxY, Bx, By);

    int[] sortedXs = xToMinY.keySet().stream().mapToInt(Integer::intValue).sorted().toArray();

    Map<Integer, Long> dp = Map.of(Ay, 0L);
    for (int x : sortedXs) {
      Map<Integer, Long> nextDp = new HashMap<>();

      int minY = xToMinY.get(x);
      int maxY = xToMaxY.get(x);

      for (int y : dp.keySet()) {
        nextDp.put(
            maxY,
            Math.min(
                nextDp.getOrDefault(maxY, Long.MAX_VALUE),
                dp.get(y) + Math.abs(y - minY) + (maxY - minY)));

        nextDp.put(
            minY,
            Math.min(
                nextDp.getOrDefault(minY, Long.MAX_VALUE),
                dp.get(y) + Math.abs(y - maxY) + (maxY - minY)));
      }

      dp = nextDp;
    }

    return (Bx - Ax) + dp.values().stream().mapToLong(Long::longValue).min().getAsLong();
  }

  static void update(Map<Integer, Integer> xToMinY, Map<Integer, Integer> xToMaxY, int x, int y) {
    xToMinY.put(x, Math.min(xToMinY.getOrDefault(x, Integer.MAX_VALUE), y));
    xToMaxY.put(x, Math.max(xToMaxY.getOrDefault(x, Integer.MIN_VALUE), y));
  }
}