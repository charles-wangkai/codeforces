import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 1_000_000_000;

  static int[] primes;

  public static void main(String[] args) throws Throwable {
    precompute();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }
  }

  static void precompute() {
    boolean[] isPrimes = new boolean[(int) Math.ceil(Math.sqrt(LIMIT)) + 1];
    Arrays.fill(isPrimes, true);

    for (int i = 2; i < isPrimes.length; ++i) {
      if (isPrimes[i]) {
        for (int j = i + i; j < isPrimes.length; j += i) {
          isPrimes[j] = false;
        }
      }
    }

    primes = IntStream.range(2, isPrimes.length).filter(i -> isPrimes[i]).toArray();
  }

  static boolean solve(int[] a) {
    Set<Integer> seen = new HashSet<>();
    for (int value : a) {
      for (int prime : primes) {
        if (prime * prime > value) {
          break;
        }

        if (value % prime == 0) {
          if (seen.contains(prime)) {
            return true;
          }
          seen.add(prime);

          while (value % prime == 0) {
            value /= prime;
          }
        }
      }
      if (value != 1) {
        if (seen.contains(value)) {
          return true;
        }
        seen.add(value);
      }
    }

    return false;
  }
}