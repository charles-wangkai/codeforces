import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {-1, -1, 0, 1, 1, 1, 0, -1};
  static final int[] C_OFFSETS = {0, 1, 1, 1, 0, -1, -1, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char[][] matrix = new char[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          matrix[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(matrix));
    }

    sc.close();
  }

  static int solve(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int oneCount = 0;
    int zeroCount = 0;
    boolean hasAdjZeros = false;
    for (int r = 0; r < n; ++r) {
      int r_ = r;
      for (int c = 0; c < m; ++c) {
        int c_ = c;
        if (matrix[r][c] == '1') {
          ++oneCount;
        } else {
          ++zeroCount;
          if (IntStream.range(0, R_OFFSETS.length)
              .anyMatch(
                  i -> {
                    int adjR = r_ + R_OFFSETS[i];
                    int adjC = c_ + C_OFFSETS[i];

                    return adjR >= 0
                        && adjR < n
                        && adjC >= 0
                        && adjC < m
                        && matrix[adjR][adjC] == '0';
                  })) {
            hasAdjZeros = true;
          }
        }
      }
    }

    int wasted;
    if (zeroCount == 0) {
      wasted = 2;
    } else if (hasAdjZeros) {
      wasted = 0;
    } else {
      wasted = 1;
    }

    return oneCount - wasted;
  }
}