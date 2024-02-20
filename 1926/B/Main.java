import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      char[][] grid = new char[n][n];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < n; ++c) {
          grid[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(grid));
    }

    sc.close();
  }

  static String solve(char[][] grid) {
    return (Arrays.stream(grid)
                .mapToInt(
                    line ->
                        (int) IntStream.range(0, line.length).filter(i -> line[i] == '1').count())
                .filter(x -> x != 0)
                .distinct()
                .count()
            == 1)
        ? "SQUARE"
        : "TRIANGLE";
  }
}