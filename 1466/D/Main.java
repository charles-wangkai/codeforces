import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] w = new int[n];
      for (int i = 0; i < w.length; ++i) {
        w[i] = sc.nextInt();
      }
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt() - 1;
        v[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(w, u, v));
    }

    sc.close();
  }

  static String solve(int[] w, int[] u, int[] v) {
    int n = w.length;

    int[] degrees = new int[n];
    for (int i = 0; i < u.length; ++i) {
      ++degrees[u[i]];
      ++degrees[v[i]];
    }

    int[] sortedWeights =
        IntStream.range(0, n)
            .flatMap(i -> IntStream.range(0, degrees[i] - 1).map(j -> w[i]))
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(x -> x)
            .toArray();

    long[] result = new long[n - 1];
    result[0] = Arrays.stream(w).asLongStream().sum();
    for (int i = 1; i < result.length; ++i) {
      result[i] = result[i - 1] + sortedWeights[i - 1];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
