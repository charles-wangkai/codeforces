import java.util.ArrayList;
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
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(int[] x) {
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < x.length; ++i) {
      valueToIndices.putIfAbsent(x[i], new ArrayList<>());
      valueToIndices.get(x[i]).add(i);
    }

    Outcome outcome =
        valueToIndices.keySet().stream()
            .map(value -> computeOutcome(valueToIndices, value))
            .reduce(Main::merge)
            .get();

    return "%d %d %d".formatted(outcome.value(), outcome.beginIndex() + 1, outcome.endIndex() + 1);
  }

  static Outcome computeOutcome(Map<Integer, List<Integer>> valueToIndices, int value) {
    List<Integer> indices = valueToIndices.get(value);
    int[] a =
        IntStream.range(0, indices.size())
            .flatMap(
                i ->
                    (i == 0)
                        ? IntStream.of(1)
                        : IntStream.of(-(indices.get(i) - indices.get(i - 1) - 1), 1))
            .toArray();

    int beginIndex = -1;
    int endIndex = -1;
    int rangeSum = -1;
    int sum = 0;
    int left = 0;
    for (int right = 0; right < a.length; ++right) {
      sum += a[right];
      if (sum > 0) {
        if (sum > rangeSum) {
          beginIndex = indices.get(left / 2);
          endIndex = indices.get(right / 2);
          rangeSum = sum;
        }
      } else {
        sum = 0;
        left = right + 1;
      }
    }

    return new Outcome(value, beginIndex, endIndex, rangeSum);
  }

  static Outcome merge(Outcome o1, Outcome o2) {
    return (o1.rangeSum() > o2.rangeSum()) ? o1 : o2;
  }
}

record Outcome(int value, int beginIndex, int endIndex, int rangeSum) {}
