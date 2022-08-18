import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] x = new int[m];
      int[] y = new int[m];
      for (int i = 0; i < m; ++i) {
        x[i] = sc.nextInt() - 1;
        y[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(a, x, y));
    }

    sc.close();
  }

  static int solve(int[] a, int[] x, int[] y) {
    if (x.length % 2 == 0) {
      return 0;
    }

    int[] counts = new int[a.length];
    for (int i = 0; i < x.length; ++i) {
      ++counts[x[i]];
      ++counts[y[i]];
    }

    int result =
        IntStream.range(0, counts.length)
            .filter(i -> counts[i] % 2 != 0)
            .map(i -> a[i])
            .min()
            .orElse(Integer.MAX_VALUE);

    for (int i = 0; i < x.length; ++i) {
      if (counts[x[i]] % 2 == 0 && counts[y[i]] % 2 == 0) {
        result = Math.min(result, a[x[i]] + a[y[i]]);
      }
    }

    return result;
  }
}