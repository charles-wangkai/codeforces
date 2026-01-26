import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    int[] missingValues =
        IntStream.rangeClosed(1, a.length).filter(x -> !valueToCount.containsKey(x)).toArray();
    int missingIndex = 0;

    int[] result = new int[a.length];
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < result.length; ++i) {
      if (seen.contains(a[i])
          || (valueToCount.get(a[i]) > 1 && missingValues[missingIndex] < a[i])) {
        result[i] = missingValues[missingIndex];
        ++missingIndex;

        valueToCount.put(a[i], valueToCount.get(a[i]) - 1);
      } else {
        result[i] = a[i];
      }

      seen.add(result[i]);
    }

    return "%d\n%s"
        .formatted(
            IntStream.range(0, result.length).filter(i -> result[i] != a[i]).count(),
            Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}