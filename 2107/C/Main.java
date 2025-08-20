import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final long NEGATIVE_INF = -10_000_000_000_000L;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      String s = sc.next();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(s, a, k));
    }

    sc.close();
  }

  static String solve(String s, int[] a, long k) {
    int n = s.length();

    long[] values =
        IntStream.range(0, n).mapToLong(i -> (s.charAt(i) == '1') ? a[i] : NEGATIVE_INF).toArray();

    long maxSubarraySum = computeMaxSubarraySum(values);
    OptionalInt missingIndex =
        IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '0').findAny();
    if (missingIndex.isPresent()) {
      if (maxSubarraySum > k) {
        return "No";
      }

      values[missingIndex.getAsInt()] =
          k
              - computeMaxSegmentSum(values, missingIndex.getAsInt(), -1)
              - computeMaxSegmentSum(values, missingIndex.getAsInt(), 1);
    } else if (maxSubarraySum != k) {
      return "No";
    }

    return "Yes\n%s"
        .formatted(
            Arrays.stream(values).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static long computeMaxSegmentSum(long[] values, int beginIndex, int offset) {
    long result = 0;
    long sum = 0;
    int index = beginIndex;
    while (true) {
      index += offset;
      if (!(index >= 0 && index < values.length)) {
        break;
      }

      sum += values[index];
      result = Math.max(result, sum);
    }

    return result;
  }

  static long computeMaxSubarraySum(long[] values) {
    long result = Long.MIN_VALUE;
    long sum = 0;
    for (long value : values) {
      sum += value;
      result = Math.max(result, sum);
      sum = Math.max(0, sum);
    }

    return result;
  }
}