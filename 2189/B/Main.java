import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long x = sc.nextLong();
      int[] a = new int[n];
      int[] b = new int[n];
      int[] c = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c, x));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b, int[] c, long x) {
    int n = a.length;

    long rest = x - IntStream.range(0, n).mapToLong(i -> (b[i] - 1L) * a[i]).sum();
    if (rest <= 0) {
      return 0;
    }

    long maxGain =
        IntStream.range(0, n).mapToLong(i -> (long) b[i] * a[i] - c[i]).max().getAsLong();
    if (maxGain <= 0) {
      return -1;
    }

    return Math.ceilDiv(rest, maxGain);
  }
}