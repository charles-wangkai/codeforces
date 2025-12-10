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

    while (true) {
      if (isLoopBegin(valueToCount)) {
        k %= 2;
      }

      if (k == 0) {
        break;
      }

      valueToCount = operate(valueToCount);
      --k;
    }

    Map<Integer, Integer> valueToCount_ = valueToCount;
    return valueToCount.keySet().stream()
        .mapToLong(value -> (long) value * valueToCount_.get(value))
        .sum();
  }

  static boolean isLoopBegin(Map<Integer, Integer> valueToCount) {
    int maxValue = valueToCount.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();

    return IntStream.range(0, maxValue).allMatch(value -> valueToCount.getOrDefault(value, 0) == 1);
  }

  static Map<Integer, Integer> operate(Map<Integer, Integer> valueToCount) {
    int mex = 0;
    while (valueToCount.containsKey(mex)) {
      ++mex;
    }

    Map<Integer, Integer> nextValueToCount = new HashMap<>();
    for (int value : valueToCount.keySet()) {
      if (value < mex && valueToCount.get(value) == 1) {
        nextValueToCount.put(value, 1);
      } else {
        nextValueToCount.put(mex, nextValueToCount.getOrDefault(mex, 0) + valueToCount.get(value));
      }
    }

    return nextValueToCount;
  }
}