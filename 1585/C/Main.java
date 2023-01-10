import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x, k));
    }

    sc.close();
  }

  static long solve(int[] x, int k) {
    return computeDistance(Arrays.stream(x).filter(xi -> xi < 0).toArray(), k)
        + computeDistance(Arrays.stream(x).filter(xi -> xi > 0).toArray(), k)
        - Arrays.stream(x).map(Math::abs).max().getAsInt();
  }

  static long computeDistance(int[] positions, int k) {
    int[] sorted =
        Arrays.stream(positions)
            .map(Math::abs)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(x -> x)
            .toArray();

    return 2
        * IntStream.range(0, sorted.length)
            .filter(i -> i % k == 0)
            .map(i -> sorted[i])
            .asLongStream()
            .sum();
  }
}
