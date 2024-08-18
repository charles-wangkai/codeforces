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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, int k) {
    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    return IntStream.range(0, sorted.length)
            .map(i -> ((i % 2 == 0) ? 1 : -1) * sorted[i])
            .asLongStream()
            .sum()
        - Math.min(
            k,
            IntStream.range(0, sorted.length / 2)
                .map(i -> sorted[i * 2] - sorted[i * 2 + 1])
                .asLongStream()
                .sum());
  }
}