import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] PRIMES = {2, 3, 5, 7};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long l = sc.nextLong();
      long r = sc.nextLong();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static long solve(long l, long r) {
    return computeGoodNum(r) - computeGoodNum(l - 1);
  }

  static long computeGoodNum(long limit) {
    return IntStream.range(0, 1 << PRIMES.length)
        .mapToLong(
            mask ->
                limit
                    / IntStream.range(0, PRIMES.length)
                        .filter(i -> ((mask >> i) & 1) != 0)
                        .map(i -> PRIMES[i])
                        .reduce((acc, x) -> acc * x)
                        .orElse(1)
                    * ((Integer.bitCount(mask) % 2 == 0) ? 1 : -1))
        .sum();
  }
}