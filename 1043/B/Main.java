import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    int[] diffs = IntStream.range(0, a.length).map(i -> a[i] - ((i == 0) ? 0 : a[i - 1])).toArray();
    int[] lengths =
        IntStream.rangeClosed(1, diffs.length)
            .filter(
                length ->
                    IntStream.range(0, diffs.length).allMatch(i -> diffs[i] == diffs[i % length]))
            .toArray();

    return "%d\n%s"
        .formatted(
            lengths.length,
            Arrays.stream(lengths).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}