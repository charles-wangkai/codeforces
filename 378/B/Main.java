import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    int n = a.length;

    int[] sorted = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, sorted.length).boxed().collect(Collectors.toMap(i -> sorted[i], i -> i));

    return "%s\n%s"
        .formatted(
            IntStream.range(0, n)
                .map(i -> (i < n / 2 || valueToIndex.get(a[i]) < n) ? 1 : 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()),
            IntStream.range(0, n)
                .map(i -> (i < n / 2 || valueToIndex.get(b[i]) < n) ? 1 : 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
  }
}