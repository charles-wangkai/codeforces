import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, k));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b, int k) {
    int n = a.length;

    int[] lowers = new int[n];
    int[] uppers = new int[n];
    for (int i = 0; i < n; ++i) {
      lowers[i] = Math.min(a[i], b[i]);
      uppers[i] = Math.max(a[i], b[i]);
    }

    int[] sortedIndices =
        IntStream.range(0, lowers.length)
            .boxed()
            .sorted(Comparator.comparing(i -> lowers[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    return IntStream.range(0, a.length).map(i -> uppers[i] - lowers[i]).asLongStream().sum()
        + 2
            * IntStream.range(0, sortedIndices.length - 1)
                .map(i -> Math.max(0, lowers[sortedIndices[i + 1]] - uppers[sortedIndices[i]]))
                .min()
                .getAsInt();
  }
}