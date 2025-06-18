import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int xc = sc.nextInt();
    int yc = sc.nextInt();
    int k = sc.nextInt();
    int[] dx = new int[k];
    int[] dy = new int[k];
    for (int i = 0; i < k; ++i) {
      dx[i] = sc.nextInt();
      dy[i] = sc.nextInt();
    }

    System.out.println(solve(n, m, xc, yc, dx, dy));

    sc.close();
  }

  static long solve(int n, int m, int xc, int yc, int[] dx, int[] dy) {
    long result = 0;
    int x = xc;
    int y = yc;
    for (int i = 0; i < dx.length; ++i) {
      int step = findStep(n, m, x, y, dx[i], dy[i]);
      result += step;
      x += dx[i] * step;
      y += dy[i] * step;
    }

    return result;
  }

  static int findStep(int n, int m, int x, int y, int deltaX, int deltaY) {
    int result = -1;
    int lower = 0;
    int upper = Math.max(n, m);
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      long nextX = x + (long) deltaX * middle;
      long nextY = y + (long) deltaY * middle;
      if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= m) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }
}