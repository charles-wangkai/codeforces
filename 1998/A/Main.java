import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int xc = sc.nextInt();
      int yc = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(xc, yc, k));
    }

    sc.close();
  }

  static String solve(int xc, int yc, int k) {
    List<Point> points = new ArrayList<>();
    int lowerX;
    int lowerY;
    int upperX;
    int upperY;
    if (k % 2 == 0) {
      lowerX = xc - 1;
      lowerY = yc - 1;
      upperX = xc + 1;
      upperY = yc + 1;

      points.add(new Point(lowerX, lowerY));
      points.add(new Point(upperX, upperY));
    } else {
      lowerX = xc;
      lowerY = yc;
      upperX = xc;
      upperY = yc;

      points.add(new Point(lowerX, lowerY));
    }

    while (points.size() != k) {
      if (points.size() % 2 == 0) {
        --lowerX;
        --lowerY;

        points.add(new Point(lowerX, lowerY));
      } else {
        ++upperX;
        ++upperY;

        points.add(new Point(upperX, upperY));
      }
    }

    return points.stream()
        .map(point -> "%d %d".formatted(point.x(), point.y()))
        .collect(Collectors.joining("\n"));
  }
}

record Point(int x, int y) {}
