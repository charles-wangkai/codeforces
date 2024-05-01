import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 1000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] h = new int[n];
      int[] w = new int[n];
      for (int i = 0; i < n; ++i) {
        h[i] = sc.nextInt();
        w[i] = sc.nextInt();
      }
      int[] hs = new int[q];
      int[] ws = new int[q];
      int[] hb = new int[q];
      int[] wb = new int[q];
      for (int i = 0; i < q; ++i) {
        hs[i] = sc.nextInt();
        ws[i] = sc.nextInt();
        hb[i] = sc.nextInt();
        wb[i] = sc.nextInt();
      }

      System.out.println(solve(h, w, hs, ws, hb, wb));
    }

    sc.close();
  }

  static String solve(int[] h, int[] w, int[] hs, int[] ws, int[] hb, int[] wb) {
    long[][] values = new long[LIMIT + 1][LIMIT + 1];
    for (int i = 0; i < h.length; ++i) {
      values[h[i]][w[i]] += h[i] * w[i];
    }

    long[][] prefixSums = new long[LIMIT + 1][LIMIT + 1];
    for (int i = 1; i <= LIMIT; ++i) {
      for (int j = 1; j <= LIMIT; ++j) {
        prefixSums[i][j] =
            prefixSums[i - 1][j] + prefixSums[i][j - 1] - prefixSums[i - 1][j - 1] + values[i][j];
      }
    }

    return IntStream.range(0, hs.length)
        .mapToLong(
            i ->
                prefixSums[hb[i] - 1][wb[i] - 1]
                    - prefixSums[hb[i] - 1][ws[i]]
                    - prefixSums[hs[i]][wb[i] - 1]
                    + prefixSums[hs[i]][ws[i]])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}