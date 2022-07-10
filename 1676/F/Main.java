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
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static String solve(int[] a, int k) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : a) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    int[] enoughValues =
        valueToCount.keySet().stream()
            .filter(value -> valueToCount.get(value) >= k)
            .sorted()
            .mapToInt(x -> x)
            .toArray();
    if (enoughValues.length == 0) {
      return "-1";
    }

    int[] beginIndices =
        IntStream.range(0, enoughValues.length)
            .filter(i -> i == 0 || enoughValues[i] != enoughValues[i - 1] + 1)
            .toArray();
    int[] lengths =
        IntStream.range(0, beginIndices.length)
            .map(
                i ->
                    ((i == beginIndices.length - 1) ? enoughValues.length : beginIndices[i + 1])
                        - beginIndices[i])
            .toArray();
    int maxLength = Arrays.stream(lengths).max().getAsInt();
    int l =
        enoughValues[
            beginIndices[
                IntStream.range(0, beginIndices.length)
                    .filter(i -> lengths[i] == maxLength)
                    .findAny()
                    .getAsInt()]];
    int r = l + maxLength - 1;

    return String.format("%d %d", l, r);
  }
}