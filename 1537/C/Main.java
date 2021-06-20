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
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h));
    }

    sc.close();
  }

  static String solve(int[] h) {
    int[] sorted = Arrays.stream(h).boxed().sorted().mapToInt(x -> x).toArray();
    if (sorted.length == 2) {
      return String.format("%d %d", sorted[0], sorted[1]);
    }

    int index1 =
        IntStream.range(0, sorted.length - 1)
            .boxed()
            .min(Comparator.comparing(i -> sorted[i + 1] - sorted[i]))
            .get();
    int index2 = index1 + 1;

    return IntStream.concat(
            IntStream.range(index2, sorted.length), IntStream.rangeClosed(0, index1))
        .mapToObj(i -> String.valueOf(sorted[i]))
        .collect(Collectors.joining(" "));
  }
}
