import java.util.Scanner;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    int[][] values = new int[n][n];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        values[r][c] = r * n + c + 1;
      }
    }

    int result = -1;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        int cost = values[r][c];
        for (int i = 0; i < R_OFFSETS.length; ++i) {
          int adjR = r + R_OFFSETS[i];
          int adjC = c + C_OFFSETS[i];
          if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < n) {
            cost += values[adjR][adjC];
          }
        }

        result = Math.max(result, cost);
      }
    }

    return result;
  }
}