import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] a = new int[2][n];
      for (int r = 0; r < a.length; ++r) {
        for (int c = 0; c < a[r].length; ++c) {
          a[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[][] a) {
    int n = a[0].length;

    return IntStream.range(0, n).map(c -> Math.max(a[0][c], a[1][c])).sum()
        + IntStream.range(0, n).map(c -> Math.min(a[0][c], a[1][c])).max().getAsInt();
  }
}