import java.util.Scanner;

public class Main {
  static final int SIZE = 3;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] grid = new char[SIZE][SIZE];
    for (int r = 0; r < SIZE; ++r) {
      String line = sc.next();
      for (int c = 0; c < SIZE; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid));

    sc.close();
  }

  static String solve(char[][] grid) {
    String result = new String(grid[0]);
    for (int r1 = 0; r1 < SIZE; ++r1) {
      for (int c1 = 0; c1 < SIZE; ++c1) {
        for (int r2 = 0; r2 < SIZE; ++r2) {
          for (int c2 = 0; c2 < SIZE; ++c2) {
            for (int r3 = 0; r3 < SIZE; ++r3) {
              for (int c3 = 0; c3 < SIZE; ++c3) {
                if (!(r3 == r1 && c3 == c1)
                    && !(r3 == r2 && c3 == c2)
                    && !(r2 == r1 && c2 == c1)
                    && computeDistance(r1, c1, r2, c2) <= 1
                    && computeDistance(r2, c2, r3, c3) <= 1) {
                  String word = String.format("%c%c%c", grid[r1][c1], grid[r2][c2], grid[r3][c3]);
                  if (word.compareTo(result) < 0) {
                    result = word;
                  }
                }
              }
            }
          }
        }
      }
    }

    return result;
  }

  static int computeDistance(int ra, int ca, int rb, int cb) {
    return Math.max(Math.abs(ra - rb), Math.abs(ca - cb));
  }
}