import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    long[] k = new long[q];
    for (int i = 0; i < k.length; ++i) {
      k[i] = sc.nextLong();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static String solve(int[] a, long[] k) {
    long[] prefixSums = new long[a.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + a[i];
    }

    int[] result = new int[k.length];
    long sum = 0;
    for (int i = 0; i < result.length; ++i) {
      sum += k[i];

      int standNum = computeStandNum(prefixSums, sum);
      if (standNum == 0) {
        result[i] = prefixSums.length;
        sum = 0;
      } else {
        result[i] = standNum;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }

  static int computeStandNum(long[] prefixSums, long target) {
    int lastIndex = -1;
    int lower = 0;
    int upper = prefixSums.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (prefixSums[middle] <= target) {
        lastIndex = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return prefixSums.length - 1 - lastIndex;
  }
}