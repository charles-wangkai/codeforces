import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int t = sc.nextInt();
    int[] x = new int[n];
    int[] a = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      a[i] = sc.nextInt();
    }

    System.out.println(solve(x, a, t));

    sc.close();
  }

  static int solve(int[] x, int[] a, int t) {
    for (int i = 0; i < x.length; ++i) {
      x[i] *= 2;
    }
    for (int i = 0; i < a.length; ++i) {
      a[i] *= 2;
    }
    t *= 2;

    int t_ = t;
    return (int)
        IntStream.range(0, x.length)
            .flatMap(i -> IntStream.of(x[i] - a[i] / 2 - t_, x[i] + a[i] / 2))
            .distinct()
            .filter(
                minX ->
                    IntStream.range(0, x.length)
                        .allMatch(i -> minX >= x[i] + a[i] / 2 || minX + t_ <= x[i] - a[i] / 2))
            .count();
  }
}