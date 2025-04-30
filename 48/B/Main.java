import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] squares = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        squares[r][c] = sc.nextInt();
      }
    }
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(squares, a, b));

    sc.close();
  }

  static int solve(int[][] squares, int a, int b) {
    int n = squares.length;
    int m = squares[0].length;

    int[][] prefixSums = new int[n + 1][m + 1];
    for (int r = 1; r <= n; ++r) {
      for (int c = 1; c <= m; ++c) {
        prefixSums[r][c] =
            prefixSums[r][c - 1]
                + prefixSums[r - 1][c]
                - prefixSums[r - 1][c - 1]
                + squares[r - 1][c - 1];
      }
    }

    int result = Integer.MAX_VALUE;
    for (int beginR = 0; beginR + a <= n; ++beginR) {
      for (int beginC = 0; beginC + b <= m; ++beginC) {
        result =
            Math.min(
                result,
                computeRangeSum(prefixSums, beginR, beginC, beginR + a - 1, beginC + b - 1));
      }
    }
    for (int beginR = 0; beginR + b <= n; ++beginR) {
      for (int beginC = 0; beginC + a <= m; ++beginC) {
        result =
            Math.min(
                result,
                computeRangeSum(prefixSums, beginR, beginC, beginR + b - 1, beginC + a - 1));
      }
    }

    return result;
  }

  static int computeRangeSum(int[][] prefixSums, int beginR, int beginC, int endR, int endC) {
    return prefixSums[endR + 1][endC + 1]
        - prefixSums[beginR][endC + 1]
        - prefixSums[endR + 1][beginC]
        + prefixSums[beginR][beginC];
  }
}