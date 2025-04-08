import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 10_000_000;

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] x = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < x.length; ++i) {
      x[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int[] l = new int[m];
    int[] r = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      l[i] = Integer.parseInt(st.nextToken());
      r[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(x, l, r));
  }

  static String solve(int[] x, int[] l, int[] r) {
    int[] counts = new int[LIMIT + 1];
    for (int xi : x) {
      ++counts[xi];
    }

    boolean[] primes = new boolean[LIMIT + 1];
    Arrays.fill(primes, true);

    int[] multipleNums = new int[LIMIT + 1];

    for (int i = 2; i < primes.length; ++i) {
      if (primes[i]) {
        for (int j = i; j < primes.length; j += i) {
          if (j != i) {
            primes[j] = false;
          }
          multipleNums[i] += counts[j];
        }
      }
    }

    long[] prefixSums = new long[multipleNums.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + multipleNums[i];
    }

    return IntStream.range(0, l.length)
        .mapToLong(i -> prefixSums[Math.min(LIMIT, r[i])] - prefixSums[Math.min(LIMIT, l[i] - 1)])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}