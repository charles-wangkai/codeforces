import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    if (k != 1 && n % 2 != 0) {
      return "NO";
    }

    int[][] grid = new int[n][k];
    for (int c = 0; c < k; ++c) {
      for (int r = 0; r < n; ++r) {
        grid[r][c] = c * n + r + 1;
      }
    }

    return String.format(
        "YES\n%s",
        Arrays.stream(grid)
            .map(l -> Arrays.stream(l).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
            .collect(Collectors.joining("\n")));
  }
}