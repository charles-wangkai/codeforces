import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int d = sc.nextInt();
      int h = sc.nextInt();
      int[] y = new int[n];
      for (int i = 0; i < y.length; ++i) {
        y[i] = sc.nextInt();
      }

      System.out.println(String.format("%.9f", solve(y, d, h)));
    }

    sc.close();
  }

  static double solve(int[] y, int d, int h) {
    return IntStream.range(0, y.length)
        .mapToDouble(
            i -> computeArea(d, h, (i == y.length - 1) ? Integer.MAX_VALUE : (y[i + 1] - y[i])))
        .sum();
  }

  static double computeArea(int d, int h, int gap) {
    if (gap >= h) {
      return 0.5 * d * h;
    }

    double top = (double) d / h * (h - gap);

    return (top + d) * gap / 2;
  }
}
