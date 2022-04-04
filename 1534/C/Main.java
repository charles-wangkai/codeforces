import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] grid = new int[2][n];
      for (int r = 0; r < grid.length; ++r) {
        for (int c = 0; c < grid[r].length; ++c) {
          grid[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(grid));
    }

    sc.close();
  }

  static int solve(int[][] grid) {
    int n = grid[0].length;

    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, n)
            .boxed()
            .collect(Collectors.toMap(i -> grid[0][i], Function.identity()));

    int result = 1;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        search(grid, valueToIndex, visited, i);

        result = result * 2 % MODULUS;
      }
    }

    return result;
  }

  static void search(
      int[][] grid, Map<Integer, Integer> valueToIndex, boolean[] visited, int index) {
    visited[index] = true;

    int otherIndex = valueToIndex.get(grid[1][index]);
    if (!visited[otherIndex]) {
      search(grid, valueToIndex, visited, otherIndex);
    }
  }
}