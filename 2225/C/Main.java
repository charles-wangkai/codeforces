import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      char[][] cells = new char[2][n];
      for (int r = 0; r < 2; ++r) {
        String line = sc.next();
        for (int c = 0; c < n; ++c) {
          cells[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(cells));
    }

    sc.close();
  }

  static int solve(char[][] cells) {
    int n = cells[0].length;

    int[] dp = new int[n + 1];
    for (int i = 1; i < dp.length; ++i) {
      dp[i] = dp[i - 1] + ((cells[0][i - 1] == cells[1][i - 1]) ? 0 : 1);
      if (i != 1) {
        dp[i] =
            Math.min(
                dp[i],
                dp[i - 2]
                    + ((cells[0][i - 2] == cells[0][i - 1]) ? 0 : 1)
                    + ((cells[1][i - 2] == cells[1][i - 1]) ? 0 : 1));
      }
    }

    return dp[dp.length - 1];
  }
}