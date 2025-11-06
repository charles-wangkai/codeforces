import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int q = sc.nextInt();
    sc.nextLine();
    String[] turns = new String[q];
    for (int i = 0; i < turns.length; ++i) {
      turns[i] = sc.nextLine();
    }

    System.out.println(solve(n, m, turns));

    sc.close();
  }

  static String solve(int n, int m, String[] turns) {
    Point[][] points = new Point[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        points[r][c] = new Point(r, c);
      }
    }

    int[][] values = new int[n][m];
    for (String turn : turns) {
      int[] fields = Arrays.stream(turn.split(" ")).mapToInt(Integer::parseInt).toArray();
      int t = fields[0];
      if (t == 1) {
        int r = fields[1];

        shiftRow(points, r - 1);
      } else if (t == 2) {
        int c = fields[1];

        shiftCol(points, c - 1);
      } else {
        int r = fields[1];
        int c = fields[2];
        int x = fields[3];

        values[points[r - 1][c - 1].r()][points[r - 1][c - 1].c()] = x;
      }
    }

    return Arrays.stream(values)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }

  static void shiftRow(Point[][] points, int row) {
    int m = points[0].length;

    Point temp = points[row][0];
    for (int c = 0; c < m - 1; ++c) {
      points[row][c] = points[row][c + 1];
    }
    points[row][m - 1] = temp;
  }

  static void shiftCol(Point[][] points, int col) {
    int n = points.length;

    Point temp = points[0][col];
    for (int r = 0; r < n - 1; ++r) {
      points[r][col] = points[r + 1][col];
    }
    points[n - 1][col] = temp;
  }
}

record Point(int r, int c) {}
