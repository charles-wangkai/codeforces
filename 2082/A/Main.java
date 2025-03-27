import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] matrix = new int[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          matrix[r][c] = line.charAt(c) - '0';
        }
      }

      System.out.println(solve(matrix));
    }

    sc.close();
  }

  static int solve(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int[] rowXors = Arrays.stream(matrix).mapToInt(Main::computeXor).toArray();
    int[] colXors =
        IntStream.range(0, m)
            .map(c -> computeXor(IntStream.range(0, n).map(r -> matrix[r][c]).toArray()))
            .toArray();

    return Math.max(
        (int) Arrays.stream(rowXors).filter(x -> x == 1).count(),
        (int) Arrays.stream(colXors).filter(x -> x == 1).count());
  }

  static int computeXor(int[] values) {
    return Arrays.stream(values).reduce((acc, x) -> acc ^ x).getAsInt();
  }
}