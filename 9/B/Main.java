import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int vb = sc.nextInt();
    int vs = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }
    int xu = sc.nextInt();
    int yu = sc.nextInt();

    System.out.println(solve(x, vb, vs, xu, yu));

    sc.close();
  }

  static int solve(int[] x, int vb, int vs, int xu, int yu) {
    double[] distances =
        Arrays.stream(x)
            .mapToDouble(xi -> Math.sqrt((long) (xi - xu) * (xi - xu) + (long) yu * yu))
            .toArray();
    double[] times =
        IntStream.range(0, x.length)
            .mapToDouble(i -> (double) x[i] / vb + distances[i] / vs)
            .toArray();

    return IntStream.range(1, times.length)
            .boxed()
            .min(
                Comparator.<Integer, Double>comparing(i -> times[i])
                    .thenComparing(i -> distances[i]))
            .get()
        + 1;
  }
}