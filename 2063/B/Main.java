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
      int l = sc.nextInt();
      int r = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, r));
    }

    sc.close();
  }

  static long solve(int[] a, int l, int r) {
    int[] inValues =
        IntStream.rangeClosed(l - 1, r - 1)
            .map(i -> a[i])
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    return Math.min(
        computeMinSum(inValues, IntStream.range(0, l - 1).map(i -> a[i]).sorted().toArray()),
        computeMinSum(inValues, IntStream.range(r, a.length).map(i -> a[i]).sorted().toArray()));
  }

  static long computeMinSum(int[] inValues, int[] outValues) {
    return Arrays.stream(inValues).asLongStream().sum()
        - IntStream.range(0, Math.min(inValues.length, outValues.length))
            .map(i -> Math.max(0, inValues[i] - outValues[i]))
            .asLongStream()
            .sum();
  }
}