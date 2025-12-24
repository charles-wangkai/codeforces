import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int row = sc.nextInt();
    int col = sc.nextInt();
    char[][] grid = new char[row][col];
    for (int r = 0; r < row; ++r) {
      String line = sc.next();
      for (int c = 0; c < col; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid));

    sc.close();
  }

  static int solve(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    Point start = null;
    Point exit = null;
    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {
        if (grid[r][c] == 'S') {
          start = new Point(r, c);
        } else if (grid[r][c] == 'E') {
          exit = new Point(r, c);
        }
      }
    }

    int[][] distances = new int[row][col];
    for (int r = 0; r < distances.length; ++r) {
      Arrays.fill(distances[r], Integer.MAX_VALUE);
    }
    distances[exit.r()][exit.c()] = 0;

    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(exit);

    while (!queue.isEmpty()) {
      Point head = queue.poll();
      for (int i = 0; i < R_OFFSETS.length; ++i) {
        int adjR = head.r() + R_OFFSETS[i];
        int adjC = head.c() + C_OFFSETS[i];
        if (adjR >= 0
            && adjR < row
            && adjC >= 0
            && adjC < col
            && grid[adjR][adjC] != 'T'
            && distances[adjR][adjC] == Integer.MAX_VALUE) {
          distances[adjR][adjC] = distances[head.r()][head.c()] + 1;
          queue.offer(new Point(adjR, adjC));
        }
      }
    }

    int result = 0;
    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {
        if (Character.isDigit(grid[r][c]) && distances[r][c] <= distances[start.r()][start.c()]) {
          result += grid[r][c] - '0';
        }
      }
    }

    return result;
  }
}

record Point(int r, int c) {}
