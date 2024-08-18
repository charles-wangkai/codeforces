import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    int[] maxDuplicates1 = computeMaxDuplicates(a);
    int[] maxDuplicates2 = computeMaxDuplicates(maxDuplicates1);

    return Arrays.stream(a).asLongStream().sum()
        + Arrays.stream(maxDuplicates1).asLongStream().sum()
        + IntStream.range(0, maxDuplicates2.length)
            .mapToLong(i -> (long) (maxDuplicates2.length - i) * maxDuplicates2[i])
            .sum();
  }

  static int[] computeMaxDuplicates(int[] values) {
    int[] result = new int[values.length];
    int maxDuplicate = 0;
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int i = 0; i < result.length; ++i) {
      valueToCount.put(values[i], valueToCount.getOrDefault(values[i], 0) + 1);
      if (valueToCount.get(values[i]) >= 2) {
        maxDuplicate = Math.max(maxDuplicate, values[i]);
      }

      result[i] = maxDuplicate;
    }

    return result;
  }
}