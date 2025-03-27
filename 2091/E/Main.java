import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static long solve(int n) {
    int[] primes = buildPrimes(n);

    long result = 0;
    int primeIndex = primes.length - 1;
    for (int i = 1; i <= n; ++i) {
      while (primeIndex != -1 && i * primes[primeIndex] > n) {
        --primeIndex;
      }

      result += primeIndex + 1;
    }

    return result;
  }

  static int[] buildPrimes(int n) {
    boolean[] isPrimes = new boolean[n + 1];
    Arrays.fill(isPrimes, true);

    for (int i = 2; i < isPrimes.length; ++i) {
      if (isPrimes[i]) {
        for (int j = i + i; j < isPrimes.length; j += i) {
          isPrimes[j] = false;
        }
      }
    }

    return IntStream.range(2, isPrimes.length).filter(i -> isPrimes[i]).toArray();
  }
}