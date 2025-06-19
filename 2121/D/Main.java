import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    int n = a.length;

    int[][] values = {a, b};
    Map<Integer, Point> valueToPoint = new HashMap<>();
    for (int r = 0; r < 2; ++r) {
      for (int c = 0; c < n; ++c) {
        valueToPoint.put(values[r][c], new Point(r, c));
      }
    }

    List<String> operations = new ArrayList<>();
    for (int value = 1; value <= 2 * n; ++value) {
      Point point = valueToPoint.get(value);
      if ((value % 2 == 1) != (point.r() == 0)) {
        operations.add("3 %d".formatted(point.c() + 1));
        swap(values, valueToPoint, 0, point.c(), 1, point.c());
      }

      while (true) {
        point = valueToPoint.get(value);
        if (point.c() == (value - 1) / 2) {
          break;
        }

        operations.add("%d %d".formatted(point.r() + 1, point.c()));
        swap(values, valueToPoint, point.r(), point.c() - 1, point.r(), point.c());
      }
    }

    return "%d\n%s".formatted(operations.size(), String.join("\n", operations));
  }

  static void swap(
      int[][] values, Map<Integer, Point> valueToPoint, int r1, int c1, int r2, int c2) {
    int temp = values[r1][c1];
    values[r1][c1] = values[r2][c2];
    values[r2][c2] = temp;

    valueToPoint.put(values[r1][c1], new Point(r1, c1));
    valueToPoint.put(values[r2][c2], new Point(r2, c2));
  }
}

record Point(int r, int c) {}
