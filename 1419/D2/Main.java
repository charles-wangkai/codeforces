import java.util.Arrays;
import java.util.Collections;
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
    int[] sorted =
        Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();

    int index = 0;
    int[] reordered = new int[sorted.length];
    for (int i = 0; i < sorted.length; ++i) {
      if (index == reordered.length) {
        index = reordered.length - 1;
      } else if (index == reordered.length + 1) {
        index = 1;
      }

      reordered[index] = sorted[i];

      index += 2;
    }

    return String.format(
        "%d\n%s",
        IntStream.range(1, reordered.length - 1)
            .filter(i -> reordered[i] < reordered[i - 1] && reordered[i] < reordered[i + 1])
            .count(),
        Arrays.stream(reordered).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
