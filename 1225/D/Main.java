import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static long solve(int[] a, int k) {
    Map<String, Integer> keyToCount = new HashMap<>();
    for (int ai : a) {
      String key = buildKey(buildPrimeToExponentRemainder(k, ai));
      keyToCount.put(key, keyToCount.getOrDefault(key, 0) + 1);
    }

    long result = 0;
    for (int ai : a) {
      Map<Integer, Integer> primeToExponentRemainder = buildPrimeToExponentRemainder(k, ai);
      String key = buildKey(primeToExponentRemainder);

      Map<Integer, Integer> primeToPairedExponentRemainder =
          primeToExponentRemainder.keySet().stream()
              .collect(
                  Collectors.toMap(
                      prime -> prime, prime -> k - primeToExponentRemainder.get(prime)));
      String pairedKey = buildKey(primeToPairedExponentRemainder);

      result +=
          pairedKey.equals(key) ? (keyToCount.get(key) - 1) : keyToCount.getOrDefault(pairedKey, 0);
    }
    result /= 2;

    return result;
  }

  static String buildKey(Map<Integer, Integer> primeToExponentRemainder) {
    return primeToExponentRemainder.keySet().stream()
        .sorted()
        .map(prime -> "%d^%d".formatted(prime, primeToExponentRemainder.get(prime)))
        .collect(Collectors.joining("*"));
  }

  static Map<Integer, Integer> buildPrimeToExponentRemainder(int k, int x) {
    Map<Integer, Integer> primeToExponentRemainder = new HashMap<>();
    for (int i = 2; i * i <= x; ++i) {
      int exponent = 0;
      while (x % i == 0) {
        ++exponent;
        x /= i;
      }

      int exponentRemainder = exponent % k;
      if (exponentRemainder != 0) {
        primeToExponentRemainder.put(i, exponentRemainder);
      }
    }
    if (x != 1) {
      primeToExponentRemainder.put(x, 1);
    }

    return primeToExponentRemainder;
  }
}