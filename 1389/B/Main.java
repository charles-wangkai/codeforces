import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int z = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k, z));
    }

    sc.close();
  }

  static int solve(int[] a, int k, int z) {
    int maxAdjSum = 0;
    int[] maxAdjSums = new int[a.length];
    for (int i = 0; i < maxAdjSums.length - 1; ++i) {
      maxAdjSum = Math.max(maxAdjSum, a[i] + a[i + 1]);
      maxAdjSums[i] = maxAdjSum;
    }

    int prefixSum = 0;
    int[] prefixSums = new int[a.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSum += a[i];
      prefixSums[i] = prefixSum;
    }

    int result = 0;
    for (int leftNum = 0; leftNum <= z; ++leftNum) {
      int endIndex = k - leftNum * 2;
      if (endIndex >= 0) {
        result = Math.max(result, prefixSums[endIndex] + maxAdjSums[endIndex] * leftNum);
      }
    }

    return result;
  }
}
