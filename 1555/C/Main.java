import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int m = sc.nextInt();
      int[][] a = new int[2][m];
      for (int i = 0; i < a.length; ++i) {
        for (int j = 0; j < a[i].length; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[][] a) {
    int m = a[0].length;

    int upSum = IntStream.range(1, m).map(i -> a[0][i]).sum();
    int downSum = 0;
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < m; ++i) {
      result = Math.min(result, Math.max(upSum, downSum));

      if (i != m - 1) {
        upSum -= a[0][i + 1];
      }
      downSum += a[1][i];
    }

    return result;
  }
}
