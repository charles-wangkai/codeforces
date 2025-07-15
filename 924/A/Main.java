import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] grid = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(char[][] grid) {
    long[] masks =
        Arrays.stream(grid)
            .mapToLong(
                line ->
                    IntStream.range(0, line.length)
                        .filter(c -> line[c] == '#')
                        .mapToLong(c -> 1L << c)
                        .sum())
            .toArray();

    for (int i = 0; i < masks.length; ++i) {
      for (int j = i + 1; j < masks.length; ++j) {
        if (masks[j] != masks[i] && (masks[i] & masks[j]) != 0) {
          return false;
        }
      }
    }

    return true;
  }
}