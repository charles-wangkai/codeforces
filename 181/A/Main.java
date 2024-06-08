import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] cells = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        cells[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(cells));

    sc.close();
  }

  static String solve(char[][] cells) {
    int n = cells.length;
    int m = cells[0].length;

    List<Point> points = new ArrayList<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (cells[r][c] == '*') {
          points.add(new Point(r, c));
        }
      }
    }

    return String.format("%d %d", findR(points) + 1, findC(points) + 1);
  }

  static int findR(List<Point> points) {
    int[] values = points.stream().mapToInt(Point::r).sorted().toArray();

    return (values[0] == values[1]) ? values[2] : values[0];
  }

  static int findC(List<Point> points) {
    int[] values = points.stream().mapToInt(Point::c).sorted().toArray();

    return (values[0] == values[1]) ? values[2] : values[0];
  }
}

record Point(int r, int c) {}
