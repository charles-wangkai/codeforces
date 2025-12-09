import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int p = sc.nextInt();
    int q = sc.nextInt();
    int r = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, p, q, r));

    sc.close();
  }

  static long solve(int[] a, int p, int q, int r) {
    int[] leftMins = new int[a.length];
    int[] leftMaxs = new int[a.length];
    for (int i = 0; i < a.length; ++i) {
      leftMins[i] = Math.min((i == 0) ? Integer.MAX_VALUE : leftMins[i - 1], a[i]);
      leftMaxs[i] = Math.max((i == 0) ? Integer.MIN_VALUE : leftMaxs[i - 1], a[i]);
    }

    int[] rightMins = new int[a.length];
    int[] rightMaxs = new int[a.length];
    for (int i = a.length - 1; i >= 0; --i) {
      rightMins[i] = Math.min((i == a.length - 1) ? Integer.MAX_VALUE : rightMins[i + 1], a[i]);
      rightMaxs[i] = Math.max((i == a.length - 1) ? Integer.MIN_VALUE : rightMaxs[i + 1], a[i]);
    }

    return IntStream.range(0, a.length)
        .boxed()
        .flatMapToLong(
            i ->
                LongStream.of(
                    (long) p * leftMins[i] + (long) q * a[i] + (long) r * rightMins[i],
                    (long) p * leftMins[i] + (long) q * a[i] + (long) r * rightMaxs[i],
                    (long) p * leftMaxs[i] + (long) q * a[i] + (long) r * rightMins[i],
                    (long) p * leftMaxs[i] + (long) q * a[i] + (long) r * rightMaxs[i]))
        .max()
        .getAsLong();
  }
}