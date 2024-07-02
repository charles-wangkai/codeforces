import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(x, y, a, b));

    sc.close();
  }

  static String solve(int[] x, int[] y, int[] a, int[] b) {
    Map<Marker, Integer> markerToCount = new HashMap<>();
    for (int i = 0; i < x.length; ++i) {
      updateMap(markerToCount, new Marker(x[i], y[i]), 1);
    }

    int beautifully = 0;
    boolean[] used = new boolean[a.length];
    for (int i = 0; i < used.length; ++i) {
      Marker marker = new Marker(a[i], b[i]);
      if (markerToCount.containsKey(marker)) {
        updateMap(markerToCount, marker, -1);
        used[i] = true;
        ++beautifully;
      }
    }

    Map<Integer, Integer> diameterToCount = new HashMap<>();
    for (Marker marker : markerToCount.keySet()) {
      diameterToCount.put(
          marker.diameter(),
          diameterToCount.getOrDefault(marker.diameter(), 0) + markerToCount.get(marker));
    }

    int closed = beautifully;
    for (int i = 0; i < used.length; ++i) {
      if (!used[i] && diameterToCount.getOrDefault(b[i], 0) != 0) {
        diameterToCount.put(b[i], diameterToCount.get(b[i]) - 1);
        ++closed;
      }
    }

    return "%d %d".formatted(closed, beautifully);
  }

  static void updateMap(Map<Marker, Integer> markerToCount, Marker marker, int delta) {
    markerToCount.put(marker, markerToCount.getOrDefault(marker, 0) + delta);
    markerToCount.remove(marker, 0);
  }
}

record Marker(int color, int diameter) {}
