import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    int n = a.length;

    return LongStream.of(
            (long) computeMinCost(a[0], b)
                + computeMinCost(a[n - 1], b)
                + computeMinCost(b[0], a)
                + computeMinCost(b[n - 1], a),
            (long) Math.abs(a[0] - b[0])
                + computeMinCost(a[n - 1], b)
                + computeMinCost(b[n - 1], a),
            (long) Math.abs(a[0] - b[n - 1])
                + computeMinCost(a[n - 1], b)
                + computeMinCost(b[0], a),
            (long) Math.abs(a[n - 1] - b[0])
                + computeMinCost(a[0], b)
                + computeMinCost(b[n - 1], a),
            (long) Math.abs(a[n - 1] - b[n - 1])
                + computeMinCost(a[0], b)
                + computeMinCost(b[0], a),
            (long) Math.abs(a[0] - b[0]) + Math.abs(a[n - 1] - b[n - 1]),
            (long) Math.abs(a[0] - b[n - 1]) + Math.abs(a[n - 1] - b[0]))
        .min()
        .getAsLong();
  }

  static int computeMinCost(int g, int[] grades) {
    return Arrays.stream(grades).map(grade -> Math.abs(g - grade)).min().getAsInt();
  }
}
