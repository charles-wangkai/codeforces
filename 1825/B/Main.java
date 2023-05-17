import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] b = new int[n][m];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
          b[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static int solve(int[][] b) {
    int n = b.length;
    int m = b[0].length;

    int minSize = Math.min(n, m);
    int[] sorted = Arrays.stream(b).flatMapToInt(Arrays::stream).sorted().toArray();

    return Math.max(
        sorted[sorted.length - 1] * (n * m)
            - (sorted[sorted.length - 1]
                + sorted[1] * (minSize - 1)
                + sorted[0] * (n * m - minSize)),
        (sorted[0]
                + sorted[sorted.length - 2] * (minSize - 1)
                + sorted[sorted.length - 1] * (n * m - minSize))
            - sorted[0] * (n * m));
  }
}
