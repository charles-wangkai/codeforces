import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(a, h, k));
    }

    sc.close();
  }

  static int solve(int[] a, int[] h, int k) {
    int n = a.length;

    int[] groups = new int[n];
    for (int i = 1; i < groups.length; ++i) {
      groups[i] = groups[i - 1] + ((h[i - 1] % h[i] == 0) ? 0 : 1);
    }

    int[] prefixSums = new int[n];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + a[i];
    }

    return IntStream.range(0, n)
        .map(i -> computeMaxLength(k, groups, prefixSums, i))
        .max()
        .getAsInt();
  }

  static int computeMaxLength(int k, int[] groups, int[] prefixSums, int beginIndex) {
    int result = 0;
    int lower = 1;
    int upper = groups.length - beginIndex;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(k, groups, prefixSums, beginIndex, beginIndex + middle - 1)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int k, int[] groups, int[] prefixSums, int beginIndex, int endIndex) {
    return groups[beginIndex] == groups[endIndex]
        && prefixSums[endIndex] - ((beginIndex == 0) ? 0 : prefixSums[beginIndex - 1]) <= k;
  }
}
