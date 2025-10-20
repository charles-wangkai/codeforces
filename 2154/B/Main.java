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
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; ++i) {
      max = Math.max(max, a[i]);
      if (i % 2 == 1) {
        a[i] = max;
      }
    }

    return IntStream.range(0, a.length)
        .filter(i -> i % 2 == 0)
        .map(
            i ->
                Math.max(
                    0,
                    a[i]
                        - Math.min(
                            (i == 0) ? Integer.MAX_VALUE : (a[i - 1] - 1),
                            (i == a.length - 1) ? Integer.MAX_VALUE : (a[i + 1] - 1))))
        .asLongStream()
        .sum();
  }
}