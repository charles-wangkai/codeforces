import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[][] a = new int[n][m];
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < m; ++c) {
          a[r][c] = sc.nextInt();
        }
      }
      char[][] s = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          s[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(a, s, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[][] a, char[][] s, int k) {
    int n = a.length;
    int m = a[0].length;

    long totalDiff = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        totalDiff += ((s[r][c] == '0') ? 1 : -1) * a[r][c];
      }
    }
    if (totalDiff == 0) {
      return true;
    }

    long[][] zeroPrefixSums = buildPrefixSums(s, '0');
    long[][] onePrefixSums = buildPrefixSums(s, '1');

    List<Long> coefficients = new ArrayList<>();
    for (int endR = k - 1; endR < n; ++endR) {
      for (int endC = k - 1; endC < m; ++endC) {
        coefficients.add(
            computeRangeSum(zeroPrefixSums, endR - k + 1, endC - k + 1, endR, endC)
                - computeRangeSum(onePrefixSums, endR - k + 1, endC - k + 1, endR, endC));
      }
    }

    return coefficients.stream().anyMatch(coefficient -> coefficient != 0)
        && totalDiff % coefficients.stream().reduce(Main::gcd).get() == 0;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }

  static long computeRangeSum(long[][] prefixSums, int beginR, int beginC, int endR, int endC) {
    return prefixSums[endR + 1][endC + 1]
        - prefixSums[endR + 1][beginC]
        - prefixSums[beginR][endC + 1]
        + prefixSums[beginR][beginC];
  }

  static long[][] buildPrefixSums(char[][] s, char type) {
    int n = s.length;
    int m = s[0].length;

    long[][] result = new long[n + 1][m + 1];
    for (int r = 1; r <= n; ++r) {
      for (int c = 1; c <= m; ++c) {
        result[r][c] =
            result[r][c - 1]
                + result[r - 1][c]
                - result[r - 1][c - 1]
                + ((s[r - 1][c - 1] == type) ? 1 : 0);
      }
    }

    return result;
  }
}