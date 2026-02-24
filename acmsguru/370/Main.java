import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(N, M));

    sc.close();
  }

  static long solve(int N, int M) {
    if (N == 1 && M == 1) {
      return 0;
    }
    if (N == 1 || M == 1) {
      return 1;
    }

    int[] factors = buildFactors(Math.max(N, M));

    long result = 2;
    for (int c = 1; c < M; ++c) {
      List<Integer> primes = buildPrimes(factors, c);
      for (int mask = 0; mask < 1 << primes.size(); ++mask) {
        int count = 0;
        int product = 1;
        for (int i = 0; i < primes.size(); ++i) {
          if (((mask >> i) & 1) == 1) {
            ++count;
            product *= primes.get(i);
          }
        }

        result += ((count % 2 == 1) ? -1 : 1) * ((N - 1) / product);
      }
    }

    return result;
  }

  static List<Integer> buildPrimes(int[] factors, int x) {
    List<Integer> primes = new ArrayList<>();
    int rest = x;
    while (factors[rest] != 0) {
      if (!primes.contains(factors[rest])) {
        primes.add(factors[rest]);
      }

      rest /= factors[rest];
    }

    return primes;
  }

  static int[] buildFactors(int limit) {
    int[] factors = new int[limit];
    for (int i = 2; i < factors.length; ++i) {
      if (factors[i] == 0) {
        for (int j = i; j < factors.length; j += i) {
          factors[j] = i;
        }
      }
    }

    return factors;
  }
}