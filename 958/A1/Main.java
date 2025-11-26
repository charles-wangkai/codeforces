import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    char[][] grid1 = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        grid1[r][c] = line.charAt(c);
      }
    }
    char[][] grid2 = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        grid2[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid1, grid2) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(char[][] grid1, char[][] grid2) {
    return IntStream.rangeClosed(0, 3)
        .anyMatch(
            rotateNum -> {
              char[][] grid = grid1;
              for (int i = 0; i < rotateNum; ++i) {
                grid = rotate(grid);
              }

              return Stream.of(grid, flipX(grid), flipY(grid), flipX(flipY(grid)))
                  .anyMatch(g -> Arrays.deepEquals(g, grid2));
            });
  }

  static char[][] rotate(char[][] grid) {
    int N = grid.length;

    char[][] result = new char[N][N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        result[r][c] = grid[c][N - 1 - r];
      }
    }

    return result;
  }

  static char[][] flipX(char[][] grid) {
    int N = grid.length;

    char[][] result = new char[N][N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        result[r][c] = grid[r][N - 1 - c];
      }
    }

    return result;
  }

  static char[][] flipY(char[][] grid) {
    int N = grid.length;

    char[][] result = new char[N][N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        result[r][c] = grid[N - 1 - r][c];
      }
    }

    return result;
  }
}