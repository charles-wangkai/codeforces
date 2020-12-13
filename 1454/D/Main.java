import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(long n) {
    Map<Long, Integer> primeToExp = new HashMap<>();
    for (int i = 2; (long) i * i <= n; ++i) {
      int exp = 0;
      while (n % i == 0) {
        ++exp;
        n /= i;
      }
      if (exp != 0) {
        primeToExp.put((long) i, exp);
      }
    }
    if (n != 1) {
      primeToExp.put(n, 1);
    }

    long[] a = new long[primeToExp.values().stream().mapToInt(x -> x).max().getAsInt()];
    Arrays.fill(a, 1);

    for (long prime : primeToExp.keySet()) {
      int exp = primeToExp.get(prime);
      for (int i = a.length - 1; i >= a.length - exp; --i) {
        a[i] *= prime;
      }
    }

    return String.format(
        "%d\n%s",
        a.length, Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
