import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      long[] a = new long[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(long[] a, long k) {
    long round = findRound(a, k);

    return (round == 0)
        ? 0
        : (round * a.length
            + Arrays.stream(a).filter(ai -> ai > round).count()
            + (k - Arrays.stream(a).map(ai -> Math.max(0, round - ai)).sum())
            - (a.length - 1));
  }

  static long findRound(long[] a, long k) {
    long result = -1;
    long lower = 0;
    long upper = (Arrays.stream(a).sum() + k) / a.length;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (Arrays.stream(a).map(ai -> Math.max(0, middle - ai)).sum() <= k) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }
}