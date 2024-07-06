import java.util.Scanner;

public class Main {
  static final long LIMIT = 5_000_000_000_000_000_000L;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();
      long x = sc.nextLong();

      System.out.println(solve(n, x));
    }

    sc.close();
  }

  static long solve(long n, long x) {
    long result = -1;
    long lower = n;
    long upper = LIMIT;
    while (lower <= upper) {
      long middle = lower + (upper - lower) / 2;
      long rangeAnd = computeRangeAnd(n, middle);
      if (rangeAnd > x) {
        lower = middle + 1;
      } else {
        if (rangeAnd == x) {
          result = middle;
        }

        upper = middle - 1;
      }
    }

    return result;
  }

  static long computeRangeAnd(long n, long m) {
    long result = 0;
    for (int i = 0; m != 0; ++i) {
      if (n == m && (n & 1) == 1) {
        result += 1L << i;
      }

      n >>= 1;
      m >>= 1;
    }

    return result;
  }
}