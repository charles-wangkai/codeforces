import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, l));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int l) {
    int n = a.length;

    int[] sortedIndices =
        IntStream.range(0, n)
            .boxed()
            .sorted(Comparator.comparing(i -> b[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    long[][] dp = new long[n][n + 1];
    for (int i = 0; i < n; ++i) {
      Arrays.fill(dp[i], Long.MAX_VALUE);

      dp[i][1] = a[sortedIndices[i]];
    }
    for (int size = 2; size <= n; ++size) {
      long minPrevContrib = Long.MAX_VALUE;
      for (int i = 0; i < n; ++i) {
        if (minPrevContrib != Long.MAX_VALUE) {
          dp[i][size] = a[sortedIndices[i]] + b[sortedIndices[i]] + minPrevContrib;
        }

        if (dp[i][size - 1] != Long.MAX_VALUE) {
          minPrevContrib = Math.min(minPrevContrib, dp[i][size - 1] - b[sortedIndices[i]]);
        }
      }
    }

    for (int size = n; size >= 1; --size) {
      for (int i = 0; i < n; ++i) {
        if (dp[i][size] <= l) {
          return size;
        }
      }
    }

    return 0;
  }
}