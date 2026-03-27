import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int h = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, h, k));
    }

    sc.close();
  }

  static long solve(int[] a, int h, int k) {
    long[] prefixSums = new long[a.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + a[i];
    }

    int[] prefixMins = new int[a.length];
    for (int i = 0; i < prefixMins.length; ++i) {
      prefixMins[i] = Math.min((i == 0) ? Integer.MAX_VALUE : prefixMins[i - 1], a[i]);
    }

    int[] suffixMaxs = new int[a.length];
    for (int i = suffixMaxs.length - 1; i >= 0; --i) {
      suffixMaxs[i] =
          Math.max((i == suffixMaxs.length - 1) ? Integer.MIN_VALUE : suffixMaxs[i + 1], a[i]);
    }

    long baseTime = (h - 1) / prefixSums[prefixSums.length - 1] * (a.length + k);
    int rest =
        h - (int) ((h - 1) / prefixSums[prefixSums.length - 1] * prefixSums[prefixSums.length - 1]);

    return baseTime
        + IntStream.range(0, prefixSums.length)
            .filter(
                i ->
                    prefixSums[i]
                            + Math.max(
                                0, (i == a.length - 1) ? 0 : (suffixMaxs[i + 1] - prefixMins[i]))
                        >= rest)
            .findFirst()
            .getAsInt()
        + 1;
  }
}