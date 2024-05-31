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
      int[] b = new int[n + 1];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    return IntStream.range(0, a.length).map(i -> Math.abs(a[i] - b[i])).asLongStream().sum()
        + IntStream.range(0, a.length)
            .map(
                i ->
                    (b[b.length - 1] >= Math.min(a[i], b[i])
                            && b[b.length - 1] <= Math.max(a[i], b[i]))
                        ? 0
                        : Math.min(
                            Math.abs(b[b.length - 1] - a[i]), Math.abs(b[b.length - 1] - b[i])))
            .min()
            .getAsInt()
        + 1;
  }
}