import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
    Map<Integer, List<Integer>> remainderToValues = new HashMap<>();
    for (int ai : a) {
      int remainder = ai % k;
      remainderToValues.putIfAbsent(remainder, new ArrayList<>());
      remainderToValues.get(remainder).add(ai / k);
    }
    for (List<Integer> values : remainderToValues.values()) {
      Collections.sort(values);
    }

    if (remainderToValues.values().stream().filter(values -> values.size() % 2 == 1).count() > 1) {
      return -1;
    }

    return remainderToValues.values().stream()
        .mapToInt(Main::computeOperationNum)
        .asLongStream()
        .sum();
  }

  static int computeOperationNum(List<Integer> values) {
    int[] leftOperationNums = new int[values.size()];
    for (int i = 1; i < leftOperationNums.length; i += 2) {
      leftOperationNums[i] =
          ((i == 1) ? 0 : leftOperationNums[i - 2]) + (values.get(i) - values.get(i - 1));
    }

    int[] rightOperationNums = new int[values.size()];
    for (int i = rightOperationNums.length - 2; i >= 0; i -= 2) {
      rightOperationNums[i] =
          ((i == rightOperationNums.length - 2) ? 0 : rightOperationNums[i + 2])
              + (values.get(i + 1) - values.get(i));
    }

    return (values.size() % 2 == 0)
        ? rightOperationNums[0]
        : IntStream.range(0, values.size())
            .filter(i -> i % 2 == 0)
            .map(
                i ->
                    ((i == 0) ? 0 : leftOperationNums[i - 1])
                        + ((i == values.size() - 1) ? 0 : rightOperationNums[i + 1]))
            .min()
            .getAsInt();
  }
}