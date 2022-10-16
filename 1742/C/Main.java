import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int SIZE = 8;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      char[][] grid = new char[SIZE][SIZE];
      for (int r = 0; r < SIZE; ++r) {
        String line = sc.next();
        for (int c = 0; c < SIZE; ++c) {
          grid[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(grid));
    }

    sc.close();
  }

  static String solve(char[][] grid) {
    return IntStream.range(0, grid.length)
            .anyMatch(r -> IntStream.range(0, SIZE).allMatch(c -> grid[r][c] == 'R'))
        ? "R"
        : "B";
  }
}
