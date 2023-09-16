import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y, k, a, b));
    }

    sc.close();
  }

  static long solve(int[] x, int[] y, int k, int a, int b) {
    long result = computeDistance(x, y, a, b);
    if (k != 0) {
      result =
          Math.min(
              result,
              IntStream.range(0, k).mapToLong(i -> computeDistance(x, y, a, i)).min().getAsLong()
                  + IntStream.range(0, k)
                      .mapToLong(i -> computeDistance(x, y, b, i))
                      .min()
                      .getAsLong());
    }

    return result;
  }

  static long computeDistance(int[] x, int[] y, int index1, int index2) {
    return (long) Math.abs(x[index1] - x[index2]) + Math.abs(y[index1] - y[index2]);
  }
}
