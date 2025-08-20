import java.util.Scanner;

public class Main {
  static final int FROM_COLOR = 2;
  static final int TO_COLOR = 3;
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int r1 = sc.nextInt();
    int c1 = sc.nextInt();
    int r2 = sc.nextInt();
    int c2 = sc.nextInt();
    int[][] grid = new int[n][n];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < n; ++c) {
        grid[r][c] = line.charAt(c) - '0';
      }
    }

    System.out.println(solve(grid, r1, c1, r2, c2));

    sc.close();
  }

  static int solve(int[][] grid, int r1, int c1, int r2, int c2) {
    int n = grid.length;

    fill(grid, r1 - 1, c1 - 1, FROM_COLOR);
    if (grid[r2 - 1][c2 - 1] == FROM_COLOR) {
      return 0;
    }

    fill(grid, r2 - 1, c2 - 1, TO_COLOR);

    int result = Integer.MAX_VALUE;
    for (int ra = 0; ra < n; ++ra) {
      for (int ca = 0; ca < n; ++ca) {
        if (grid[ra][ca] == FROM_COLOR) {
          for (int rb = 0; rb < n; ++rb) {
            for (int cb = 0; cb < n; ++cb) {
              if (grid[rb][cb] == TO_COLOR) {
                result = Math.min(result, (ra - rb) * (ra - rb) + (ca - cb) * (ca - cb));
              }
            }
          }
        }
      }
    }

    return result;
  }

  static void fill(int[][] grid, int r, int c, int color) {
    int n = grid.length;

    grid[r][c] = color;

    for (int i = 0; i < R_OFFSETS.length; ++i) {
      int adjR = r + R_OFFSETS[i];
      int adjC = c + C_OFFSETS[i];
      if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < n && grid[adjR][adjC] == 0) {
        fill(grid, adjR, adjC, color);
      }
    }
  }
}