import java.util.Scanner;

public class Main {
  static final int SIZE = 10;

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

  static int solve(char[][] grid) {
    int result = 0;
    for (int r = 0; r < SIZE; ++r) {
      for (int c = 0; c < SIZE; ++c) {
        if (grid[r][c] == 'X') {
          result += Math.min(Math.min(r, SIZE - 1 - r), Math.min(c, SIZE - 1 - c)) + 1;
        }
      }
    }

    return result;
  }
}
