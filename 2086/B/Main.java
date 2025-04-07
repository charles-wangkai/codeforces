import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      long x = sc.nextLong();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k, x));
    }

    sc.close();
  }

  static long solve(int[] a, int k, long x) {
    long[] suffixSums = new long[a.length];
    for (int i = suffixSums.length - 1; i >= 0; --i) {
      suffixSums[i] = ((i == suffixSums.length - 1) ? 0 : suffixSums[i + 1]) + a[i];
    }

    long index = -1;
    long lower = 0;
    long upper = (long) a.length * k - 1;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (check(suffixSums, k, x, middle)) {
        index = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return index + 1;
  }

  static boolean check(long[] suffixSums, int k, long x, long l) {
    return suffixSums[(int) (l % suffixSums.length)]
            + suffixSums[0] * (k - 1 - l / suffixSums.length)
        >= x;
  }
}