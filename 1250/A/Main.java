import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(n, a));

    sc.close();
  }

  static String solve(int n, int[] a) {
    int[] values = IntStream.rangeClosed(1, n).toArray();

    Map<Integer, Integer> valueToIndex = new HashMap<>();
    Map<Integer, Integer> valueToMinIndex = new HashMap<>();
    Map<Integer, Integer> valueToMaxIndex = new HashMap<>();
    for (int i = 0; i < values.length; ++i) {
      valueToIndex.put(values[i], i);
      valueToMinIndex.put(values[i], i);
      valueToMaxIndex.put(values[i], i);
    }

    for (int ai : a) {
      int index = valueToIndex.get(ai);
      if (index != 0) {
        int temp = values[index];
        values[index] = values[index - 1];
        values[index - 1] = temp;

        for (int offset = -1; offset <= 0; ++offset) {
          valueToIndex.put(values[index + offset], index + offset);
          valueToMinIndex.put(
              values[index + offset],
              Math.min(valueToMinIndex.get(values[index + offset]), index + offset));
          valueToMaxIndex.put(
              values[index + offset],
              Math.max(valueToMaxIndex.get(values[index + offset]), index + offset));
        }
      }
    }

    return IntStream.rangeClosed(1, n)
        .mapToObj(
            value ->
                "%d %d".formatted(valueToMinIndex.get(value) + 1, valueToMaxIndex.get(value) + 1))
        .collect(Collectors.joining("\n"));
  }
}