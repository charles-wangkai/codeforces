import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      int x = sc.nextInt();
      int a = sc.nextInt();
      int y = sc.nextInt();
      int b = sc.nextInt();
      long k = sc.nextLong();

      System.out.println(solve(p, x, a, y, b, k));
    }

    sc.close();
  }

  static int solve(int[] p, int x, int a, int y, int b, long k) {
    Arrays.sort(p);

    int result = -1;
    int lower = 1;
    int upper = p.length;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(p, x, a, y, b, k, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] p, int x, int a, int y, int b, long k, int length) {
    int[] factors = new int[length];
    for (int i = a - 1; i < factors.length; i += a) {
      factors[i] += x;
    }
    for (int i = b - 1; i < factors.length; i += b) {
      factors[i] += y;
    }
    Arrays.sort(factors);

    return IntStream.range(0, factors.length)
            .map(i -> p[p.length - 1 - i] / 100 * factors[factors.length - 1 - i])
            .asLongStream()
            .sum()
        >= k;
  }
}