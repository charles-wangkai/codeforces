import java.io.File;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();
    int[] x = new int[K];
    int[] y = new int[K];
    for (int i = 0; i < K; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    out.println(solve(N, M, x, y));

    out.close();
    sc.close();
  }

  static String solve(int N, int M, int[] x, int[] y) {
    int[][] distances = new int[N][M];
    for (int r = 0; r < N; ++r) {
      Arrays.fill(distances[r], -1);
    }

    Queue<Point> queue = new ArrayDeque<>();

    for (int i = 0; i < x.length; ++i) {
      distances[x[i] - 1][y[i] - 1] = 0;
      queue.offer(new Point(x[i] - 1, y[i] - 1));
    }

    while (!queue.isEmpty()) {
      Point head = queue.poll();
      for (int i = 0; i < R_OFFSETS.length; ++i) {
        int adjR = head.r() + R_OFFSETS[i];
        int adjC = head.c() + C_OFFSETS[i];
        if (adjR >= 0 && adjR < N && adjC >= 0 && adjC < M && distances[adjR][adjC] == -1) {
          distances[adjR][adjC] = distances[head.r()][head.c()] + 1;
          queue.offer(new Point(adjR, adjC));
        }
      }
    }

    int maxDistance = -1;
    int bestR = -1;
    int bestC = -1;
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < M; ++c) {
        if (distances[r][c] > maxDistance) {
          maxDistance = distances[r][c];
          bestR = r;
          bestC = c;
        }
      }
    }

    return "%d %d".formatted(bestR + 1, bestC + 1);
  }
}

record Point(int r, int c) {}
