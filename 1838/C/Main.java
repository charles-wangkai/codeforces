import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static String solve(int n, int m) {
    int[][] grid = new int[n][m];
    int beginC = 0;
    for (int r = 0; r < n; ++r) {
      for (int i = 0; i < m; ++i) {
        grid[r][(beginC + i) % m] = r * m + i + 1;
      }

      if (m % 2 == 1) {
        beginC = Math.floorMod(beginC - 1, m);
      }
    }

    return Arrays.stream(grid)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}
