import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
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

  static long solve(int[] a) {
    int[] sorted = Arrays.stream(a).sorted().distinct().toArray();
    Map<Integer, Integer> valueToCompressed =
        IntStream.range(0, sorted.length)
            .boxed()
            .collect(Collectors.toMap(i -> sorted[i], i -> i + 1));

    int[] compressed = Arrays.stream(a).map(valueToCompressed::get).toArray();

    int[] rightSmallerNums = buildRightSmallerNums(compressed);
    int[] leftLargerNums =
        reverse(
            buildRightSmallerNums(
                reverse(
                    IntStream.range(0, compressed.length)
                        .map(i -> sorted.length + 1 - compressed[i])
                        .toArray())));

    return IntStream.range(0, a.length)
        .mapToLong(i -> (long) leftLargerNums[i] * rightSmallerNums[i])
        .sum();
  }

  static int[] buildRightSmallerNums(int[] values) {
    int[] result = new int[values.length];
    int[] binaryIndexedTree = new int[Integer.highestOneBit(values.length) * 2 + 1];
    for (int i = result.length - 1; i >= 0; --i) {
      result[i] = computeSum(binaryIndexedTree, values[i]);
      add(binaryIndexedTree, values[i], 1);
    }

    return result;
  }

  static int[] reverse(int[] values) {
    return IntStream.range(0, values.length).map(i -> values[values.length - 1 - i]).toArray();
  }

  static void add(int[] binaryIndexedTree, int i, int x) {
    while (i < binaryIndexedTree.length) {
      binaryIndexedTree[i] += x;
      i += i & -i;
    }
  }

  static int computeSum(int[] binaryIndexedTree, int i) {
    int result = 0;
    while (i != 0) {
      result += binaryIndexedTree[i];
      i -= i & -i;
    }

    return result;
  }
}