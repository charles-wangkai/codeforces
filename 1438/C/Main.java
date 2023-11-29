import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

  static String solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    SortedMap<Integer, List<Point>> valueToPoints = new TreeMap<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        valueToPoints.putIfAbsent(a[r][c], new ArrayList<>());
        valueToPoints.get(a[r][c]).add(new Point(r, c));
      }
    }

    int[][] result = new int[n][m];
    int count = 0;
    for (List<Point> points : valueToPoints.values()) {
      for (Point point : points) {
        result[point.r()][point.c()] =
            a[point.r()][point.c()] + (((point.r() + point.c()) % 2 == count % 2) ? 0 : 1);
      }

      ++count;
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}

record Point(int r, int c) {}
