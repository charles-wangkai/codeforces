import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a));
  }

  static int solve(int[] a) {
    int g = Arrays.stream(a).reduce(Main::gcd).getAsInt();

    int[] primeFactors = buildPrimeFactors(Arrays.stream(a).map(ai -> ai / g).max().getAsInt());

    Map<Integer, Integer> primeFactorToCount = new HashMap<>();
    for (int ai : a) {
      Set<Integer> primeFactorSet = new HashSet<>();
      int rest = ai / g;
      while (primeFactors[rest] != -1) {
        primeFactorSet.add(primeFactors[rest]);
        rest /= primeFactors[rest];
      }

      for (int primeFactor : primeFactorSet) {
        primeFactorToCount.put(primeFactor, primeFactorToCount.getOrDefault(primeFactor, 0) + 1);
      }
    }

    return primeFactorToCount.isEmpty()
        ? -1
        : (a.length
            - primeFactorToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt());
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }

  static int[] buildPrimeFactors(int limit) {
    int[] primeFactors = new int[limit + 1];
    Arrays.fill(primeFactors, -1);

    for (int i = 2; i < primeFactors.length; ++i) {
      if (primeFactors[i] == -1) {
        for (int j = i; j < primeFactors.length; j += i) {
          if (primeFactors[j] == -1) {
            primeFactors[j] = i;
          }
        }
      }
    }

    return primeFactors;
  }
}