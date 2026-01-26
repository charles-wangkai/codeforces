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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    long[] bPrefixSums = new long[b.length + 1];
    for (int i = 1; i < bPrefixSums.length; ++i) {
      bPrefixSums[i] = bPrefixSums[i - 1] + b[i - 1];
    }

    Arrays.sort(a);

    long result = Long.MIN_VALUE;
    int completeCount = b.length;
    for (int i = 0; i < a.length; ++i) {
      while (bPrefixSums[completeCount] > a.length - i) {
        --completeCount;
      }

      result = Math.max(result, (long) a[i] * completeCount);
    }

    return result;
  }
}