import java.util.Scanner;
import java.util.stream.Collectors;
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

  static String solve(int n) {
    int[] primes = new int[n + 1];
    int value = 2;
    for (int i = 0; i < primes.length; ++i) {
      while (!isPrime(value)) {
        ++value;
      }

      primes[i] = value;
      ++value;
    }

    return IntStream.range(0, n)
        .mapToLong(i -> (long) primes[i] * primes[i + 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static boolean isPrime(int x) {
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }

    return true;
  }
}