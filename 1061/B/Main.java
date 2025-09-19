import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, m));

    sc.close();
  }

  static long solve(int[] a, int m) {
    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    for (int i = 1; i < sorted.length; ++i) {
      sorted[i] = Math.max(1, Math.min(sorted[i - 1] - 1, sorted[i]));
    }

    return Arrays.stream(a).asLongStream().sum()
        - IntStream.range(0, sorted.length)
            .map(i -> Math.max(1, sorted[i] - ((i == sorted.length - 1) ? 0 : sorted[i + 1])))
            .sum();
  }
}