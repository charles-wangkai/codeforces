import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] a = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        a[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[][] a) {
    int result = a.length;
    while (isMirror(a, result)) {
      result /= 2;
    }

    return result;
  }

  static boolean isMirror(int[][] a, int row) {
    int m = a[0].length;

    if (row % 2 == 1) {
      return false;
    }

    for (int r = 0; r < row / 2; ++r) {
      for (int c = 0; c < m; ++c) {
        if (a[r][c] != a[row - 1 - r][c]) {
          return false;
        }
      }
    }

    return true;
  }
}