// https://www.hankcs.com/program/algorithm/codeforces-138d-world-of-darkraft-notes-challenge-programming-contest.html
// https://en.wikipedia.org/wiki/Sprague%E2%80%93Grundy_theorem

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] squares = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        squares[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(squares) ? "WIN" : "LOSE");

    sc.close();
  }

  static boolean solve(char[][] squares) {
    int n = squares.length;
    int m = squares[0].length;

    return (computeNimber(
                createCache(n, m),
                true,
                squares,
                encodeRcSum(0, 0),
                encodeRcSum(n - 1, m - 1),
                encodeRcDiff(m, 0, m - 1),
                encodeRcDiff(m, n - 1, 0))
            ^ computeNimber(
                createCache(n, m),
                false,
                squares,
                encodeRcSum(0, 0),
                encodeRcSum(n - 1, m - 1),
                encodeRcDiff(m, 0, m - 1),
                encodeRcDiff(m, n - 1, 0)))
        != 0;
  }

  static int[][][][] createCache(int n, int m) {
    int maxRcSum = encodeRcSum(n - 1, m - 1);
    int maxRcDiff = encodeRcDiff(m, n - 1, 0);

    int[][][][] result = new int[maxRcSum + 1][maxRcSum + 1][maxRcDiff + 1][maxRcDiff + 1];
    for (int i = 0; i < result.length; ++i) {
      for (int j = 0; j < result[i].length; ++j) {
        for (int k = 0; k < result[i][j].length; ++k) {
          Arrays.fill(result[i][j][k], -1);
        }
      }
    }

    return result;
  }

  static int computeNimber(
      int[][][][] cache,
      boolean isRcSumEven,
      char[][] squares,
      int minRcSum,
      int maxRcSum,
      int minRcDiff,
      int maxRcDiff) {
    int n = squares.length;
    int m = squares[0].length;

    if (minRcSum > maxRcSum || minRcDiff > maxRcDiff) {
      return 0;
    }

    if (cache[minRcSum][maxRcSum][minRcDiff][maxRcDiff] == -1) {
      Set<Integer> nimbers = new HashSet<Integer>();
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < m; ++c) {
          int rcSum = encodeRcSum(r, c);
          int rcDiff = encodeRcDiff(m, r, c);
          if ((rcSum % 2 == 0) == isRcSumEven
              && rcSum >= minRcSum
              && rcSum <= maxRcSum
              && rcDiff >= minRcDiff
              && rcDiff <= maxRcDiff) {
            int nimber;
            if (squares[r][c] == 'L') {
              nimber =
                  computeNimber(
                          cache, isRcSumEven, squares, minRcSum, rcSum - 1, minRcDiff, maxRcDiff)
                      ^ computeNimber(
                          cache, isRcSumEven, squares, rcSum + 1, maxRcSum, minRcDiff, maxRcDiff);
            } else if (squares[r][c] == 'R') {
              nimber =
                  computeNimber(
                          cache, isRcSumEven, squares, minRcSum, maxRcSum, minRcDiff, rcDiff - 1)
                      ^ computeNimber(
                          cache, isRcSumEven, squares, minRcSum, maxRcSum, rcDiff + 1, maxRcDiff);
            } else {
              nimber =
                  computeNimber(
                          cache, isRcSumEven, squares, minRcSum, rcSum - 1, minRcDiff, rcDiff - 1)
                      ^ computeNimber(
                          cache, isRcSumEven, squares, rcSum + 1, maxRcSum, minRcDiff, rcDiff - 1)
                      ^ computeNimber(
                          cache, isRcSumEven, squares, minRcSum, rcSum - 1, rcDiff + 1, maxRcDiff)
                      ^ computeNimber(
                          cache, isRcSumEven, squares, rcSum + 1, maxRcSum, rcDiff + 1, maxRcDiff);
            }

            nimbers.add(nimber);
          }
        }
      }

      cache[minRcSum][maxRcSum][minRcDiff][maxRcDiff] = mex(nimbers);
    }

    return cache[minRcSum][maxRcSum][minRcDiff][maxRcDiff];
  }

  static int mex(Set<Integer> nimbers) {
    for (int i = 0; ; ++i) {
      if (!nimbers.contains(i)) {
        return i;
      }
    }
  }

  static int encodeRcSum(int r, int c) {
    return r + c;
  }

  static int encodeRcDiff(int m, int r, int c) {
    return r - c + (m - 1);
  }
}
