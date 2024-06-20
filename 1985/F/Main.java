import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int h = sc.nextInt();
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(h, a, c));
    }

    sc.close();
  }

  static long solve(int h, int[] a, int[] c) {
    long result = -1;
    long lower = 1;
    long upper =
        IntStream.range(0, a.length)
            .mapToLong(i -> 1 + (Math.max(0, h - a[i]) + a[i] - 1L) / a[i] * c[i])
            .min()
            .getAsLong();
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (check(h, a, c, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int h, int[] a, int[] c, long turn) {
    return IntStream.range(0, a.length).mapToLong(i -> a[i] + (turn - 1) / c[i] * a[i]).sum() >= h;
  }
}