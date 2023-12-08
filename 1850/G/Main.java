import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.IntFunction;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static long solve(int[] x, int[] y) {
    @SuppressWarnings("unchecked")
    IntFunction<Integer>[] keyGenerators =
        new IntFunction[] {i -> x[i], i -> y[i], i -> x[i] + y[i], i -> x[i] - y[i]};

    return Arrays.stream(keyGenerators)
        .mapToLong(keyGenerator -> computePairNum(x.length, keyGenerator))
        .sum();
  }

  static long computePairNum(int n, IntFunction<Integer> keyGenerator) {
    Map<Integer, Integer> keyToCount = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      int key = keyGenerator.apply(i);
      keyToCount.put(key, keyToCount.getOrDefault(key, 0) + 1);
    }

    return keyToCount.values().stream().mapToLong(count -> count * (count - 1L)).sum();
  }
}