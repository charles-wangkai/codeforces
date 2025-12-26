import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n + 1];
    int[] y = new int[n + 1];
    for (int i = 0; i < n + 1; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    return (int)
        IntStream.range(0, x.length - 2)
            .filter(
                i ->
                    computeCrossProduct(
                            x[i + 1] - x[i],
                            y[i + 1] - y[i],
                            x[i + 2] - x[i + 1],
                            y[i + 2] - y[i + 1])
                        > 0)
            .count();
  }

  static int computeCrossProduct(int x1, int y1, int x2, int y2) {
    return x1 * y2 - x2 * y1;
  }
}