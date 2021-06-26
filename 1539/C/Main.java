import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long k = sc.nextLong();
    long x = sc.nextLong();
    long[] a = new long[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextLong();
    }

    System.out.println(solve(a, k, x));

    sc.close();
  }

  static int solve(long[] a, long k, long x) {
    long[] sorted = Arrays.stream(a).boxed().sorted().mapToLong(ai -> ai).toArray();
    long[] gaps =
        IntStream.range(0, sorted.length - 1)
            .mapToLong(i -> sorted[i + 1] - sorted[i])
            .filter(g -> g > x)
            .boxed()
            .sorted()
            .mapToLong(g -> g)
            .toArray();

    int result = gaps.length + 1;
    for (long gap : gaps) {
      long needed = Math.max(0, gap - 1) / x;
      if (k >= needed) {
        k -= needed;
        --result;
      }
    }

    return result;
  }
}
