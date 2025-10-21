import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] a = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        a[r][c] = sc.nextInt();
      }
    }
    int[][] b = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        b[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(a, b) ? "Possible" : "Impossible");

    sc.close();
  }

  static boolean solve(int[][] a, int[][] b) {
    int n = a.length;
    int m = a[0].length;

    int[][] matrix1 = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        matrix1[r][c] = Math.min(a[r][c], b[r][c]);
      }
    }

    int[][] matrix2 = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        matrix2[r][c] = Math.max(a[r][c], b[r][c]);
      }
    }

    return isIncreasing(matrix1) && isIncreasing(matrix2);
  }

  static boolean isIncreasing(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    return Arrays.stream(matrix).allMatch(Main::isIncreasing)
        && IntStream.range(0, m)
            .allMatch(c -> isIncreasing(IntStream.range(0, n).map(r -> matrix[r][c]).toArray()));
  }

  static boolean isIncreasing(int[] values) {
    return IntStream.range(0, values.length - 1).allMatch(i -> values[i] < values[i + 1]);
  }
}