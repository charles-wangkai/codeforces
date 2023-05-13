import java.util.ArrayDeque;
import java.util.Queue;
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

  static int solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    int result = 0;
    boolean[][] visited = new boolean[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (!visited[r][c] && a[r][c] != 0) {
          result = Math.max(result, search(a, visited, r, c));
        }
      }
    }

    return result;
  }

  static int search(int[][] a, boolean[][] visited, int r, int c) {
    int n = a.length;
    int m = a[0].length;

    visited[r][c] = true;
    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(r, c));

    int result = 0;
    while (!queue.isEmpty()) {
      Point head = queue.poll();
      result += a[head.r()][head.c()];

      for (int i = 0; i < R_OFFSETS.length; ++i) {
        int adjR = head.r() + R_OFFSETS[i];
        int adjC = head.c() + C_OFFSETS[i];
        if (adjR >= 0
            && adjR < n
            && adjC >= 0
            && adjC < m
            && !visited[adjR][adjC]
            && a[adjR][adjC] != 0) {
          visited[adjR][adjC] = true;
          queue.offer(new Point(adjR, adjC));
        }
      }
    }

    return result;
  }
}

record Point(int r, int c) {}
