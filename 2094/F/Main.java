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
      int k = sc.nextInt();

      System.out.println(solve(n, m, k));
    }

    sc.close();
  }

  static String solve(int n, int m, int k) {
    int[][] result = new int[n][m];
    int offset = -1;
    int count = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (count == 0) {
          offset = findOffset(k, result, r, c);
        }

        result[r][c] = (offset + count) % k + 1;

        count = (count + 1) % k;
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }

  static int findOffset(int k, int[][] grid, int beginR, int beginC) {
    for (int offset = 0; ; ++offset) {
      if (check(k, grid, beginR, beginC, offset)) {
        return offset;
      }
    }
  }

  static boolean check(int k, int[][] grid, int beginR, int beginC, int offset) {
    int r = beginR;
    int c = beginC;
    for (int i = 0; i < k; ++i) {
      if (c == grid[0].length) {
        ++r;
        c = 0;
      }

      grid[r][c] = (i + offset) % k + 1;
      if ((r != 0 && grid[r][c] == grid[r - 1][c]) || (c != 0 && grid[r][c] == grid[r][c - 1])) {
        return false;
      }

      ++c;
    }

    return true;
  }
}