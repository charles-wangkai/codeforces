import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    List<Point> points = new ArrayList<>();
    if (n == 2) {
      points.add(new Point(1, 1));
      points.add(new Point(1, 2));
    } else if (n == 3) {
      points.add(new Point(2, 1));
      points.add(new Point(2, 3));
      points.add(new Point(3, 1));
    } else if (n == 4) {
      points.add(new Point(1, 1));
      points.add(new Point(1, 3));
      points.add(new Point(4, 3));
      points.add(new Point(4, 4));
    } else {
      for (int i = 1; i <= n - 2; ++i) {
        points.add(new Point(1, i));
      }
      points.add(new Point(n - 3, n));
      points.add(new Point(n, n));
    }

    return points.stream()
        .map(point -> "%d %d".formatted(point.x(), point.y()))
        .collect(Collectors.joining("\n"));
  }
}

record Point(int x, int y) {}
