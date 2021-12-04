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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing((Integer i) -> a[i]).reversed())
            .mapToInt(i -> i + 1)
            .toArray();

    int[] x = new int[a.length + 1];
    for (int i = 0; i < sortedIndices.length; ++i) {
      x[sortedIndices[i]] = ((i % 2 == 0) ? 1 : -1) * (i / 2 + 1);
    }

    long T =
        IntStream.range(0, a.length).mapToLong(i -> 2L * a[i] * Math.abs(x[i + 1] - x[0])).sum();

    return String.format(
        "%d\n%s", T, Arrays.stream(x).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
