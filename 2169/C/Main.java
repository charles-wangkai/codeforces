import java.util.Arrays;
import java.util.Scanner;

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

  static long solve(int[] a) {
    long[] prefixSums = new long[a.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + a[i - 1];
    }

    long result = Arrays.stream(a).asLongStream().sum();

    long maxLTerm = Long.MIN_VALUE;
    int bestL = -1;
    for (int r = 1; r <= a.length; ++r) {
      long lTerm = r - (long) r * r + prefixSums[r - 1];
      if (lTerm > maxLTerm) {
        maxLTerm = lTerm;
        bestL = r;
      }

      result =
          Math.max(
              result,
              prefixSums[bestL - 1]
                  + (bestL + r) * (r - bestL + 1L)
                  + (prefixSums[a.length] - prefixSums[r]));
    }

    return result;
  }
}