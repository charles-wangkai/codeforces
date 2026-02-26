import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      long a = sc.nextLong();
      long m = sc.nextLong();

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static long solve(long a, long m) {
    long g = gcd(a, m);
    long[] primeFactors = computePrimeFactors(m / g);

    long result = 0;
    for (int mask = 0; mask < 1 << primeFactors.length; ++mask) {
      int mask_ = mask;
      result +=
          ((Integer.bitCount(mask) % 2 == 0) ? 1 : -1)
              * computeMultipleNum(
                  a,
                  m,
                  g
                      * IntStream.range(0, primeFactors.length)
                          .filter(i -> ((mask_ >> i) & 1) == 1)
                          .mapToLong(i -> primeFactors[i])
                          .reduce(1, (acc, x) -> acc * x));
    }

    return result;
  }

  static long computeMultipleNum(long a, long m, long factor) {
    return (a + m - 1) / factor - Math.ceilDiv(a, factor) + 1;
  }

  static long[] computePrimeFactors(long x) {
    List<Long> result = new ArrayList<>();
    for (int i = 2; (long) i * i <= x; ++i) {
      if (x % i == 0) {
        result.add((long) i);

        while (x % i == 0) {
          x /= i;
        }
      }
    }
    if (x != 1) {
      result.add(x);
    }

    return result.stream().mapToLong(Long::longValue).toArray();
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}