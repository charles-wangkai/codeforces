import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String[] grid = new String[2];
      for (int i = 0; i < grid.length; ++i) {
        grid[i] = sc.next();
      }

      System.out.println(solve(grid) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String[] grid) {
    return IntStream.range(0, grid[0].length())
        .allMatch(i -> isSame(grid[0].charAt(i), grid[1].charAt(i)));
  }

  static boolean isSame(char c1, char c2) {
    return c1 == c2 || c1 + c2 == 'G' + 'B';
  }
}