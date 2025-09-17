import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, int k) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }
    if (valueToCount.values().stream().anyMatch(count -> count % k != 0)) {
      return 0;
    }

    Map<Integer, Integer> valueToUnitMaxCount =
        valueToCount.keySet().stream()
            .collect(Collectors.toMap(value -> value, value -> valueToCount.get(value) / k));

    long result = 0;
    Map<Integer, Integer> valueToFreq = new HashMap<>();
    int endIndex = -1;
    for (int beginIndex = 0; beginIndex < a.length; ++beginIndex) {
      while (endIndex != a.length - 1
          && valueToFreq.getOrDefault(a[endIndex + 1], 0) + 1
              <= valueToUnitMaxCount.get(a[endIndex + 1])) {
        ++endIndex;
        valueToFreq.put(a[endIndex], valueToFreq.getOrDefault(a[endIndex], 0) + 1);
      }

      result += endIndex - beginIndex + 1;

      valueToFreq.put(a[beginIndex], valueToFreq.get(a[beginIndex]) - 1);
    }

    return result;
  }
}