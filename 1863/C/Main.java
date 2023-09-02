import java.util.Arrays;
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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static String solve(int[] a, int k) {
    int[] values = Arrays.copyOf(a, a.length + 1);
    values[values.length - 1] =
        (int) (a.length * (a.length + 1L) / 2 - Arrays.stream(a).asLongStream().sum());

    int beginIndex = (int) ((long) k * a.length % values.length);

    return IntStream.range(0, a.length)
        .map(i -> values[(beginIndex + i) % values.length])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}
