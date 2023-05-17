import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] c = new int[n][m];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
          c[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(c));
    }

    sc.close();
  }

  static long solve(int[][] c) {
    int n = c.length;
    int m = c[0].length;

    return IntStream.range(0, m)
        .mapToLong(
            j -> computeWinningSum(IntStream.range(0, n).map(i -> c[i][j]).sorted().toArray()))
        .sum();
  }

  static long computeWinningSum(int[] sorted) {
    long result = 0;
    for (int i = 0; i < sorted.length - 1; ++i) {
      result += (sorted[i + 1] - sorted[i]) * (i + 1L) * (sorted.length - i - 1);
    }

    return result;
  }
}
