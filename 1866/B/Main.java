import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] A = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < A.length; ++i) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    int[] B = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < B.length; ++i) {
      B[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int[] C = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < C.length; ++i) {
      C[i] = Integer.parseInt(st.nextToken());
    }
    int[] D = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < D.length; ++i) {
      D[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(A, B, C, D));
  }

  static int solve(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> xPrimeToExponent = buildPrimeToExponent(A, B);
    Map<Integer, Integer> yPrimeToExponent = buildPrimeToExponent(C, D);

    for (int yPrime : yPrimeToExponent.keySet()) {
      if (xPrimeToExponent.getOrDefault(yPrime, 0) < yPrimeToExponent.get(yPrime)) {
        return 0;
      }

      xPrimeToExponent.put(yPrime, xPrimeToExponent.get(yPrime) - yPrimeToExponent.get(yPrime));
      xPrimeToExponent.remove(yPrime, 0);
    }

    return IntStream.range(0, xPrimeToExponent.size()).reduce(1, (acc, x) -> multiplyMod(acc, 2));
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static Map<Integer, Integer> buildPrimeToExponent(int[] primes, int[] exponents) {
    return IntStream.range(0, primes.length)
        .boxed()
        .collect(Collectors.toMap(i -> primes[i], i -> exponents[i]));
  }
}