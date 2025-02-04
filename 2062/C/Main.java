import java.util.Arrays;
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

  static long solve(int[] a) {
    long[] values = Arrays.stream(a).asLongStream().toArray();

    long result = Arrays.stream(values).sum();
    while (values.length != 1) {
      long[] values_ = values;
      values =
          IntStream.range(0, values.length - 1)
              .mapToLong(i -> values_[i + 1] - values_[i])
              .toArray();

      result = Math.max(result, Math.abs(Arrays.stream(values).sum()));
    }

    return result;
  }
}
