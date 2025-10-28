import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 200001;

  static int[] factors;

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
      int[] b = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < b.length; ++i) {
        b[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a, b));
    }
  }

  static void precompute() {
    factors = IntStream.rangeClosed(0, LIMIT).toArray();

    for (int i = 2; i < factors.length; ++i) {
      if (factors[i] == i) {
        for (int j = i; j < factors.length; j += i) {
          factors[j] = i;
        }
      }
    }
  }

  static int solve(int[] a, int[] b) {
    Map<Integer, Integer> factorToExactCount = new HashMap<>();
    Map<Integer, Integer> factorToBelowCount = new HashMap<>();
    for (int ai : a) {
      update(factorToExactCount, ai);
      update(factorToBelowCount, ai + 1);
    }

    int result = 2;
    for (int factor : factorToExactCount.keySet()) {
      if (factorToExactCount.get(factor) >= 2) {
        result = Math.min(result, 0);
      } else if (factorToBelowCount.containsKey(factor)) {
        result = Math.min(result, 1);
      }
    }

    return result;
  }

  static void update(Map<Integer, Integer> factorToCount, int value) {
    while (value != 1) {
      int factor = factors[value];
      factorToCount.put(factor, factorToCount.getOrDefault(factor, 0) + 1);

      while (value % factor == 0) {
        value /= factor;
      }
    }
  }
}
