import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }
      int xs = sc.nextInt();
      int ys = sc.nextInt();
      int xt = sc.nextInt();
      int yt = sc.nextInt();

      System.out.println(solve(x, y, xs, ys, xt, yt) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] x, int[] y, int xs, int ys, int xt, int yt) {
    return IntStream.range(0, x.length)
        .allMatch(
            i -> computeDistanceSquare(x[i], y[i], xt, yt) > computeDistanceSquare(xs, ys, xt, yt));
  }

  static long computeDistanceSquare(int x1, int y1, int x2, int y2) {
    return (long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2);
  }
}