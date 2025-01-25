import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String a = sc.next();
      String b = sc.next();
      String c = sc.next();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static int solve(String a, String b, String c) {
    int[][] dp = new int[a.length() + 1][b.length() + 1];
    for (int i = 0; i <= a.length(); ++i) {
      for (int j = 0; j <= b.length(); ++j) {
        if (i != 0 || j != 0) {
          dp[i][j] =
              Math.min(
                  (i == 0)
                      ? Integer.MAX_VALUE
                      : (dp[i - 1][j] + ((a.charAt(i - 1) == c.charAt(i + j - 1)) ? 0 : 1)),
                  (j == 0)
                      ? Integer.MAX_VALUE
                      : (dp[i][j - 1] + ((b.charAt(j - 1) == c.charAt(i + j - 1)) ? 0 : 1)));
        }
      }
    }

    return dp[a.length()][b.length()];
  }
}