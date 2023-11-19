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
    long result = 0;
    for (int k = 1; k <= a.length; ++k) {
      if (a.length % k == 0) {
        long[] sums = new long[a.length / k];
        for (int i = 0; i < a.length; ++i) {
          sums[i / k] += a[i];
        }

        result =
            Math.max(
                result,
                Arrays.stream(sums).max().getAsLong() - Arrays.stream(sums).min().getAsLong());
      }
    }

    return result;
  }
}
