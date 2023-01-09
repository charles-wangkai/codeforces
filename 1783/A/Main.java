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
    int[] sorted =
        Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();

    return (sorted[0] == sorted[sorted.length - 1])
        ? "NO"
        : String.format(
            "YES\n%s",
            IntStream.range(0, sorted.length)
                .map(i -> sorted[Math.floorMod(i - 1, sorted.length)])
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}
