import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int xa = sc.nextInt();
    int ya = sc.nextInt();
    int xb = sc.nextInt();
    int yb = sc.nextInt();
    int n = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    int[] r = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(xa, ya, xb, yb, x, y, r));

    sc.close();
  }

  static int solve(int xa, int ya, int xb, int yb, int[] x, int[] y, int[] r) {
    int result = 0;
    for (int xk = Math.min(xa, xb); xk <= Math.max(xa, xb); ++xk) {
      for (int yk = Math.min(ya, yb); yk <= Math.max(ya, yb); ++yk) {
        int xk_ = xk;
        int yk_ = yk;
        if ((xk == xa || xk == xb || yk == ya || yk == yb)
            && IntStream.range(0, x.length)
                .allMatch(i -> computeDistanceSquare(xk_, yk_, x[i], y[i]) > r[i] * r[i])) {
          ++result;
        }
      }
    }

    return result;
  }

  static int computeDistanceSquare(int x1, int y1, int x2, int y2) {
    return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
  }
}