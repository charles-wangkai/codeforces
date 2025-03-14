import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int POPULATION_TARGET = 1_000_000;
  static final int ITERATION_NUM = 100;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int s = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    int[] k = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      k[i] = sc.nextInt();
    }

    System.out.println(solve(x, y, k, s));

    sc.close();
  }

  static String solve(int[] x, int[] y, int[] k, int s) {
    if (s + Arrays.stream(k).sum() < POPULATION_TARGET) {
      return "-1";
    }

    double lower = 0;
    double upper =
        IntStream.range(0, x.length)
            .mapToDouble(i -> Math.sqrt((long) x[i] * x[i] + (long) y[i] * y[i]))
            .max()
            .getAsDouble();
    for (int i = 0; i < ITERATION_NUM; ++i) {
      double middle = (lower + upper) / 2;
      if (check(x, y, k, s, middle)) {
        upper = middle;
      } else {
        lower = middle;
      }
    }

    return String.format("%.9f", lower);
  }

  static boolean check(int[] x, int[] y, int[] k, int s, double radius) {
    return s
            + IntStream.range(0, x.length)
                .filter(i -> Math.sqrt((long) x[i] * x[i] + (long) y[i] * y[i]) <= radius)
                .map(i -> k[i])
                .sum()
        >= POPULATION_TARGET;
  }
}