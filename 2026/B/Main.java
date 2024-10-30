import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long[] a = new long[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(long[] a) {
    return (a.length % 2 == 0)
        ? computeK(a, -1)
        : IntStream.range(0, a.length).mapToLong(i -> computeK(a, i)).min().getAsLong();
  }

  static long computeK(long[] a, int excludedIndex) {
    long[] values =
        IntStream.range(0, a.length).filter(i -> i != excludedIndex).mapToLong(i -> a[i]).toArray();

    return IntStream.range(0, values.length / 2)
        .mapToLong(i -> values[i * 2 + 1] - values[i * 2])
        .max()
        .orElse(1);
  }
}