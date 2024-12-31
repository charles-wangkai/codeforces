import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }
    int[] v = new int[n];
    for (int i = 0; i < v.length; ++i) {
      v[i] = sc.nextInt();
    }

    System.out.println(String.format("%.9f", solve(x, v)));

    sc.close();
  }

  static double solve(int[] x, int[] v) {
    double result = -1;
    double lower = 0;
    double upper = (double) Arrays.stream(x).max().getAsInt() / Arrays.stream(v).min().getAsInt();
    for (int i = 0; i < 100; ++i) {
      double middle = (lower + upper) / 2;
      if (check(x, v, middle)) {
        result = middle;
        upper = middle;
      } else {
        lower = middle;
      }
    }

    return result;
  }

  static boolean check(int[] x, int[] v, double time) {
    return IntStream.range(0, x.length).mapToDouble(i -> x[i] - v[i] * time).max().getAsDouble()
        <= IntStream.range(0, x.length).mapToDouble(i -> x[i] + v[i] * time).min().getAsDouble();
  }
}
