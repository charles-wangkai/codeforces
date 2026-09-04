import java.util.Arrays;
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
      long[] b = new long[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextLong();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(long[] b) {
    Map<Long, Integer> valueToCount = new HashMap<>();
    for (long bi : b) {
      valueToCount.put(bi, valueToCount.getOrDefault(bi, 0) + 1);
    }

    long[] sortedValues =
        valueToCount.keySet().stream().mapToLong(Long::longValue).sorted().toArray();
    if (sortedValues[0] != 0) {
      return "-1";
    }

    Map<Long, Long> valueToMapped = new HashMap<>();
    for (int i = 0; i < sortedValues.length; ++i) {
      if (i == sortedValues.length - 1) {
        valueToMapped.put(
            sortedValues[i], (i == 0) ? 1 : (valueToMapped.get(sortedValues[i - 1]) + 1));
      } else {
        int count = valueToCount.get(sortedValues[i]);
        long sum = sortedValues[i + 1] - sortedValues[i];
        if (sum % count != 0) {
          return "-1";
        }

        valueToMapped.put(sortedValues[i], sum / count);
      }
    }
    if (IntStream.range(0, sortedValues.length - 1)
        .anyMatch(
            i -> valueToMapped.get(sortedValues[i]) >= valueToMapped.get(sortedValues[i + 1]))) {
      return "-1";
    }

    return Arrays.stream(b)
        .map(valueToMapped::get)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}