// https://en.wikipedia.org/wiki/Gray_code

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(N, M));

    sc.close();
  }

  static String solve(int N, int M) {
    int[] rowCodes = buildCodes(N);
    int[] colCodes = buildCodes(M);

    int[][] matrix = new int[1 << N][1 << M];
    for (int r = 0; r < matrix.length; ++r) {
      for (int c = 0; c < matrix[0].length; ++c) {
        matrix[r][c] = rowCodes[r] * (1 << M) + colCodes[c];
      }
    }

    StringBuilder result = new StringBuilder();
    for (int r = 0; r < matrix.length; ++r) {
      for (int c = 0; c < matrix[0].length; ++c) {
        if (c != 0) {
          result.append(" ");
        }
        result.append(matrix[r][c]);
      }
      result.append("\n");
    }

    return result.toString();
  }

  static int[] buildCodes(int n) {
    if (n == 1) {
      return new int[] {0, 1};
    }

    int[] half = buildCodes(n - 1);
    int[] result = Arrays.copyOf(half, half.length * 2);
    for (int i = half.length; i < result.length; ++i) {
      result[i] = half[result.length - 1 - i] + (1 << (n - 1));
    }

    return result;
  }
}
