import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(n, a));
    }

    sc.close();
  }

  static String solve(int n, int[] a) {
    Arrays.sort(a);

    return IntStream.range(0, (a.length + 1) / 2)
        .boxed()
        .flatMap(
            i ->
                Stream.of(new Pair(a[i], a[a.length - 1 - i]), new Pair(a[a.length - 1 - i], a[i])))
        .sorted(
            Comparator.<Pair, Integer>comparing(
                    pair -> Math.abs(pair.classroom1() - pair.classroom2()))
                .reversed())
        .limit(n)
        .map(
            pair ->
                "%d %d %d %d %d %d"
                    .formatted(
                        pair.classroom1(),
                        pair.classroom2(),
                        pair.classroom1(),
                        pair.classroom2(),
                        pair.classroom1(),
                        pair.classroom2()))
        .collect(Collectors.joining("\n"));
  }
}

record Pair(int classroom1, int classroom2) {}
