import java.util.Scanner;

public class Main {
  static final int SIZE = 2;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] grid1 = new char[SIZE][SIZE];
    for (int r = 0; r < SIZE; ++r) {
      String line = sc.next();
      for (int c = 0; c < SIZE; ++c) {
        grid1[r][c] = line.charAt(c);
      }
    }
    char[][] grid2 = new char[SIZE][SIZE];
    for (int r = 0; r < SIZE; ++r) {
      String line = sc.next();
      for (int c = 0; c < SIZE; ++c) {
        grid2[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid1, grid2) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(char[][] grid1, char[][] grid2) {
    return generateKey(grid1).equals(generateKey(grid2));
  }

  static String generateKey(char[][] grid) {
    String result =
        "%c%c%c%c".formatted(grid[0][0], grid[0][1], grid[1][1], grid[1][0]).replace("X", "");
    while (!result.startsWith("A")) {
      result = "%s%c".formatted(result.substring(1), result.charAt(0));
    }

    return result;
  }
}