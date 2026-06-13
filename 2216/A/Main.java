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
      int k = sc.nextInt();
      int[] a = new int[k];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b, a));
    }

    sc.close();
  }

  static String solve(int[] b, int[] a) {
    int k = a.length;

    int[] operations =
        IntStream.range(0, b.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> b[i]).reversed())
            .flatMapToInt(i -> IntStream.range(0, k + 1 - b[i]).map(j -> i + 1))
            .toArray();

    return "%d\n%s"
        .formatted(
            operations.length,
            Arrays.stream(operations).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}