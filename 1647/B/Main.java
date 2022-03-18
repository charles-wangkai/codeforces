import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char[][] cells = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          cells[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(cells) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(char[][] cells) {
    int n = cells.length;
    int m = cells[0].length;

    boolean[][] visited = new boolean[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (!visited[r][c] && cells[r][c] == '1') {
          List<Point> points = new ArrayList<>();
          search(points, cells, visited, r, c);

          int minR = points.stream().mapToInt(p -> p.r).min().getAsInt();
          int maxR = points.stream().mapToInt(p -> p.r).max().getAsInt();
          int minC = points.stream().mapToInt(p -> p.c).min().getAsInt();
          int maxC = points.stream().mapToInt(p -> p.c).max().getAsInt();

          if (points.size() != (maxR - minR + 1) * (maxC - minC + 1)) {
            return false;
          }
        }
      }
    }

    return true;
  }

  static void search(List<Point> points, char[][] cells, boolean[][] visited, int r, int c) {
    int n = cells.length;
    int m = cells[0].length;

    visited[r][c] = true;
    points.add(new Point(r, c));

    for (int i = 0; i < R_OFFSETS.length; ++i) {
      int adjR = r + R_OFFSETS[i];
      int adjC = c + C_OFFSETS[i];
      if (adjR >= 0
          && adjR < n
          && adjC >= 0
          && adjC < m
          && !visited[adjR][adjC]
          && cells[adjR][adjC] == '1') {
        search(points, cells, visited, adjR, adjC);
      }
    }
  }
}

class Point {
  int r;
  int c;

  Point(int r, int c) {
    this.r = r;
    this.c = c;
  }
}