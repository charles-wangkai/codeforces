import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] r = new int[m];
      double[] p = new double[m];
      for (int i = 0; i < m; ++i) {
        r[i] = sc.nextInt();
        p[i] = sc.nextDouble();
      }

      System.out.println(String.format("%.9f", solve(a, r, p)));
    }

    sc.close();
  }

  static double solve(int[] a, int[] r, double[] p) {
    int minLength = a.length;
    while (minLength != 0 && a[minLength - 1] == minLength) {
      --minLength;
    }

    int minLength_ = minLength;
    return (minLength == 0)
        ? 1
        : IntStream.range(0, r.length)
            .filter(i -> r[i] >= minLength_)
            .mapToDouble(i -> 1 - p[i])
            .reduce((x, y) -> x * y)
            .stream()
            .map(x -> 1 - x)
            .findAny()
            .orElse(0);
  }
}
