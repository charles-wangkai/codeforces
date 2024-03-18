import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
      int k = sc.nextInt();
      int[] a = new int[2 * n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static String solve(int[] a, int k) {
    int n = a.length / 2;

    Map<Integer, Integer> leftValueToCount =
        buildValueToCount(IntStream.range(0, n).map(i -> a[i]).toArray());
    Map<Integer, Integer> rightValueToCount =
        buildValueToCount(IntStream.range(n, 2 * n).map(i -> a[i]).toArray());

    int[] leftDoubleValues =
        leftValueToCount.keySet().stream()
            .filter(leftValue -> leftValueToCount.get(leftValue) == 2)
            .mapToInt(Integer::intValue)
            .toArray();
    int[] rightDoubleValues =
        rightValueToCount.keySet().stream()
            .filter(rightValue -> rightValueToCount.get(rightValue) == 2)
            .mapToInt(Integer::intValue)
            .toArray();

    List<Integer> lefts = new ArrayList<>();
    List<Integer> rights = new ArrayList<>();
    for (int i = 0; i < Math.min(k, leftDoubleValues.length); ++i) {
      lefts.add(leftDoubleValues[i]);
      lefts.add(leftDoubleValues[i]);

      rights.add(rightDoubleValues[i]);
      rights.add(rightDoubleValues[i]);
    }

    for (int value : leftValueToCount.keySet()) {
      if (lefts.size() != 2 * k && leftValueToCount.get(value) == 1) {
        lefts.add(value);
        rights.add(value);
      }
    }

    return String.format(
        "%s\n%s",
        lefts.stream().map(String::valueOf).collect(Collectors.joining(" ")),
        rights.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static Map<Integer, Integer> buildValueToCount(int[] values) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : values) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return valueToCount;
  }
}