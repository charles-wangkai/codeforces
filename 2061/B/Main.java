import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Scanner;
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
    Arrays.sort(a);

    OptionalInt legIndex = IntStream.range(0, a.length - 1).filter(i -> a[i] == a[i + 1]).findAny();
    if (legIndex.isEmpty()) {
      return "-1";
    }

    int leg = a[legIndex.getAsInt()];

    int[] rest =
        IntStream.range(0, a.length)
            .filter(i -> i != legIndex.getAsInt() && i != legIndex.getAsInt() + 1)
            .map(i -> a[i])
            .toArray();

    int index =
        IntStream.range(0, rest.length - 1)
            .boxed()
            .min(Comparator.comparing(i -> rest[i + 1] - rest[i]))
            .get();
    if (rest[index + 1] - rest[index] >= 2 * leg) {
      return "-1";
    }

    return "%d %d %d %d".formatted(leg, leg, rest[index], rest[index + 1]);
  }
}
