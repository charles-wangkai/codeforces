import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    Set<Integer> sums = new HashSet<>();
    OptionalInt boundaryIndex =
        IntStream.range(0, a.length).filter(i -> a[i] != -1 && a[i] != 1).findAny();
    if (boundaryIndex.isPresent()) {
      int[] leftValues = IntStream.range(0, boundaryIndex.getAsInt()).map(i -> a[i]).toArray();
      int[] rightValues =
          IntStream.range(boundaryIndex.getAsInt() + 1, a.length).map(i -> a[i]).toArray();

      addSumRange(sums, -computeMaxSubArray(negate(leftValues)), computeMaxSubArray(leftValues));
      addSumRange(sums, -computeMaxSubArray(negate(rightValues)), computeMaxSubArray(rightValues));
      addSumRange(
          sums,
          a[boundaryIndex.getAsInt()]
              - computeMaxPrefixSum(reverse(negate(leftValues)))
              - computeMaxPrefixSum(negate(rightValues)),
          a[boundaryIndex.getAsInt()]
              + computeMaxPrefixSum(reverse(leftValues))
              + computeMaxPrefixSum(rightValues));
    } else {
      addSumRange(sums, -computeMaxSubArray(negate(a)), computeMaxSubArray(a));
    }

    return "%d\n%s"
        .formatted(
            sums.size(),
            sums.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int computeMaxPrefixSum(int[] values) {
    int result = 0;
    int prefixSum = 0;
    for (int value : values) {
      prefixSum += value;
      result = Math.max(result, prefixSum);
    }

    return result;
  }

  static void addSumRange(Set<Integer> sums, int minSum, int maxSum) {
    sums.addAll(IntStream.rangeClosed(minSum, maxSum).boxed().toList());
  }

  static int computeMaxSubArray(int[] values) {
    int result = 0;
    int sum = 0;
    for (int value : values) {
      sum = Math.max(0, sum + value);
      result = Math.max(result, sum);
    }

    return result;
  }

  static int[] negate(int[] values) {
    return Arrays.stream(values).map(x -> -x).toArray();
  }

  static int[] reverse(int[] values) {
    return IntStream.range(0, values.length).map(i -> values[values.length - 1 - i]).toArray();
  }
}