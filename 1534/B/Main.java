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
    return IntStream.range(0, a.length + 1)
            .map(i -> Math.abs(((i == a.length) ? 0 : a[i]) - ((i == 0) ? 0 : a[i - 1])))
            .asLongStream()
            .sum()
        - IntStream.range(0, a.length)
            .map(
                i ->
                    Math.max(
                        0,
                        a[i]
                            - Math.max(
                                (i == 0) ? 0 : a[i - 1], (i == a.length - 1) ? 0 : a[i + 1])))
            .asLongStream()
            .sum();
  }
}
