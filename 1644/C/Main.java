import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static String solve(int[] a, int x) {
    int[] prefixSums = new int[a.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + a[i];
    }

    int[] result = new int[a.length + 1];
    int maxSum = Integer.MIN_VALUE;
    for (int i = result.length - 1; i >= 1; --i) {
      for (int beginIndex = 0; beginIndex + i - 1 < a.length; ++beginIndex) {
        int endIndex = beginIndex + i - 1;
        maxSum = Math.max(maxSum, computeRangeSum(prefixSums, beginIndex, endIndex));
      }

      result[i] = maxSum + i * x;
    }
    result[0] = Math.max(0, maxSum);

    for (int i = 1; i < result.length; ++i) {
      result[i] = Math.max(result[i - 1], result[i]);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static int computeRangeSum(int[] prefixSums, int beginIndex, int endIndex) {
    return prefixSums[endIndex] - ((beginIndex == 0) ? 0 : prefixSums[beginIndex - 1]);
  }
}