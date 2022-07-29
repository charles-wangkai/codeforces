import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static final int MODULUS = 1_000_000_007;
  static final int OPERATION_LIMIT = 200_000;

  static int[][] dp = new int[OPERATION_LIMIT + 1][10];

  public static void main(String[] args) throws Throwable {
    precompute();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    StringBuilder out = new StringBuilder();
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      out.append(solve(n, m)).append("\n");
    }
    System.out.print(out);
  }

  static int solve(int n, int m) {
    int result = 0;
    while (n != 0) {
      result = addMod(result, dp[m][n % 10]);
      n /= 10;
    }

    return result;
  }

  static void precompute() {
    Arrays.fill(dp[0], 1);
    for (int i = 1; i < dp.length; ++i) {
      for (int j = 0; j <= 8; ++j) {
        dp[i][j] = dp[i - 1][j + 1];
      }

      dp[i][9] = addMod(dp[i - 1][1], dp[i - 1][0]);
    }
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }
}