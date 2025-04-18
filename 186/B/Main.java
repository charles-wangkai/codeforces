import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int t1 = sc.nextInt();
    int t2 = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, t1, t2, k));

    sc.close();
  }

  static String solve(int[] a, int[] b, int t1, int t2, int k) {
    double[] heights =
        IntStream.range(0, a.length)
            .mapToDouble(
                i ->
                    Math.max(
                        computeHeight(t1, t2, k, a[i], b[i]), computeHeight(t1, t2, k, b[i], a[i])))
            .toArray();

    int[] sortedIndices =
        IntStream.range(0, heights.length)
            .boxed()
            .sorted(
                Comparator.<Integer, Integer>comparing(i -> (int) Math.round(heights[i] * 100))
                    .reversed()
                    .thenComparing(i -> i))
            .mapToInt(Integer::intValue)
            .toArray();

    return IntStream.range(0, sortedIndices.length)
        .mapToObj(i -> "%d %.2f".formatted(sortedIndices[i] + 1, heights[sortedIndices[i]]))
        .collect(Collectors.joining("\n"));
  }

  static double computeHeight(int t1, int t2, int k, int speed1, int speed2) {
    return speed1 * t1 * (1 - k / 100.0) + speed2 * t2;
  }
}