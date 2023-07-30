import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long[] a = new long[n - 1];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(long[] a) {
    int n = a.length + 1;

    long[] diffs =
        IntStream.range(0, a.length).mapToLong(i -> a[i] - ((i == 0) ? 0 : a[i - 1])).toArray();
    Set<Long> diffSet = Arrays.stream(diffs).boxed().collect(Collectors.toSet());

    int[] missings = IntStream.rangeClosed(1, n).filter(i -> !diffSet.contains((long) i)).toArray();

    return (missings.length == 1 || missings.length == 2)
        && Arrays.equals(
            IntStream.concat(
                    IntStream.rangeClosed(1, n).filter(i -> diffSet.contains((long) i)),
                    (missings.length == 1)
                        ? IntStream.empty()
                        : IntStream.of(missings[0] + missings[1]))
                .sorted()
                .asLongStream()
                .toArray(),
            Arrays.stream(diffs).sorted().toArray());
  }
}
