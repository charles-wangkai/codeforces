import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    return Arrays.stream(grid).map(String::new).collect(Collectors.joining()).replace(".", "");
  }
}
