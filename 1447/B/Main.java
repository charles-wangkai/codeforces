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

    boolean hasZero = false;
    int negativeCount = 0;
    int minAbs = Integer.MAX_VALUE;
    int absSum = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (a[r][c] == 0) {
          hasZero = true;
        } else if (a[r][c] < 0) {
          ++negativeCount;
        }
        minAbs = Math.min(minAbs, Math.abs(a[r][c]));
        absSum += Math.abs(a[r][c]);
      }
    }

    return absSum - ((hasZero || negativeCount % 2 == 0) ? 0 : minAbs) * 2;
  }
}
