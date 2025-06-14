import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static int[] primes;

  public static void main(String[] args) {
    preprocess();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static void preprocess() {
    boolean[] isPrimes = new boolean[10_000_000];
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

  static int solve(int[] a) {
    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int result = a.length;
    long valueSum = 0;
    long primeSum = 0;
    for (int i = 0; i < sorted.length; ++i) {
      valueSum += sorted[i];
      primeSum += primes[i];
      if (valueSum < primeSum) {
        break;
      }

      --result;
    }

    return result;
  }
}