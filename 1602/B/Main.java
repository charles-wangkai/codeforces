import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int q = sc.nextInt();
      int[] x = new int[q];
      int[] k = new int[q];
      for (int i = 0; i < q; ++i) {
        x[i] = sc.nextInt();
        k[i] = sc.nextInt();
      }

      System.out.println(solve(a, x, k));
    }

    sc.close();
  }

  static String solve(int[] a, int[] x, int[] k) {
    int[] sortedQueryIndices =
        IntStream.range(0, x.length)
            .boxed()
            .sorted(Comparator.comparing(i -> k[i]))
            .mapToInt(i -> i)
            .toArray();

    int[] result = new int[x.length];
    int step = 0;
    boolean changed = true;
    for (int queryIndex : sortedQueryIndices) {
      if (changed) {
        while (step < k[queryIndex] && changed) {
          int[] next = transform(a);
          changed = !Arrays.equals(a, next);

          ++step;
          a = next;
        }
      }

      result[queryIndex] = a[x[queryIndex] - 1];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }

  static int[] transform(int[] values) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : values) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return Arrays.stream(values).map(valueToCount::get).toArray();
  }
}
