import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] a = new int[n][m];
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < m; ++c) {
          a[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    int result = -1;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        result =
            Math.max(
                result,
                a[r][c]
                    + computeLineSum(a, r, c, -1, 1)
                    + computeLineSum(a, r, c, 1, 1)
                    + computeLineSum(a, r, c, 1, -1)
                    + computeLineSum(a, r, c, -1, -1));
      }
    }

    return result;
  }

  static int computeLineSum(int[][] a, int r, int c, int rOffset, int cOffset) {
    int n = a.length;
    int m = a[0].length;

    int result = 0;
    while (true) {
      r += rOffset;
      c += cOffset;
      if (!(r >= 0 && r < n && c >= 0 && c < m)) {
        return result;
      }

      result += a[r][c];
    }
  }
}