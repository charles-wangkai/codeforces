import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int v = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m, v));
    }

    sc.close();
  }

  static long solve(int[] a, int m, int v) {
    int n = a.length;

    int[] leftPieceCounts = new int[n + 1];
    int leftSum = 0;
    for (int i = 1; i <= n; ++i) {
      leftPieceCounts[i] = leftPieceCounts[i - 1];

      leftSum += a[i - 1];
      if (leftSum >= v) {
        ++leftPieceCounts[i];
        leftSum = 0;
      }
    }
    if (leftPieceCounts[n] < m) {
      return -1;
    }

    int[] rightPieceCounts = new int[n + 2];
    int rightSum = 0;
    for (int i = n; i >= 1; --i) {
      rightPieceCounts[i] = rightPieceCounts[i + 1];

      rightSum += a[i - 1];
      if (rightSum >= v) {
        ++rightPieceCounts[i];
        rightSum = 0;
      }
    }

    long[] leftSums = new long[n + 1];
    for (int i = 1; i <= n; ++i) {
      leftSums[i] = leftSums[i - 1] + a[i - 1];
    }

    long[] rightSums = new long[n + 2];
    for (int i = n; i >= 1; --i) {
      rightSums[i] = rightSums[i + 1] + a[i - 1];
    }

    long total = Arrays.stream(a).asLongStream().sum();

    long result = Long.MIN_VALUE;
    int rightIndex = n + 1;
    for (int leftIndex = 0; leftIndex <= n; ++leftIndex) {
      while (rightIndex != n + 1
          && leftPieceCounts[leftIndex] + rightPieceCounts[rightIndex] >= m) {
        ++rightIndex;
      }
      while (leftPieceCounts[leftIndex] + rightPieceCounts[rightIndex] < m) {
        --rightIndex;
      }

      if (leftIndex < rightIndex) {
        result = Math.max(result, total - leftSums[leftIndex] - rightSums[rightIndex]);
      }
    }

    return result;
  }
}