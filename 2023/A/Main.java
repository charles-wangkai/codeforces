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
      int[] a1 = new int[n];
      int[] a2 = new int[n];
      for (int i = 0; i < n; ++i) {
        a1[i] = sc.nextInt();
        a2[i] = sc.nextInt();
      }

      System.out.println(solve(a1, a2));
    }

    sc.close();
  }

  static String solve(int[] a1, int[] a2) {
    int[] sortedIndices =
        IntStream.range(0, a1.length)
            .boxed()
            .sorted(
                Comparator.<Integer, Integer>comparing(i -> Math.min(a1[i], a2[i]))
                    .thenComparing(i -> Math.max(a1[i], a2[i])))
            .mapToInt(Integer::intValue)
            .toArray();

    return Arrays.stream(sortedIndices)
        .flatMap(i -> IntStream.of(a1[i], a2[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}