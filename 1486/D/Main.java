// https://codeforces.com/blog/entry/87849

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static int solve(int[] a, int k) {
    int result = -1;
    int lower = Arrays.stream(a).min().getAsInt();
    int upper = Arrays.stream(a).max().getAsInt();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, k, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int k, int medianThreshold) {
    int[] prefixSums = new int[a.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + ((a[i - 1] >= medianThreshold) ? 1 : -1);
    }

    int min = Integer.MAX_VALUE;
    for (int i = k; i < prefixSums.length; ++i) {
      min = Math.min(min, prefixSums[i - k]);
      if (prefixSums[i] - min > 0) {
        return true;
      }
    }

    return false;
  }
}