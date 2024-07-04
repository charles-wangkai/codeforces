import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int r = sc.nextInt();
    int c = sc.nextInt();
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(r, c, x, y, k));

    sc.close();
  }

  static int solve(int r, int c, int[] x, int[] y, int k) {
    int result = 0;
    for (int minX = 1; minX <= r; ++minX) {
      for (int minY = 1; minY <= c; ++minY) {
        for (int maxX = minX; maxX <= r; ++maxX) {
          for (int maxY = minY; maxY <= c; ++maxY) {
            int minX_ = minX;
            int maxX_ = maxX;
            int minY_ = minY;
            int maxY_ = maxY;
            if (IntStream.range(0, x.length)
                    .filter(i -> x[i] >= minX_ && x[i] <= maxX_ && y[i] >= minY_ && y[i] <= maxY_)
                    .count()
                >= k) {
              ++result;
            }
          }
        }
      }
    }

    return result;
  }
}