import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(solve(n, m));

    sc.close();
  }

  static int solve(int n, int m) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 0; i < 2 * m - 1; ++i) {
      int[] nextDp = new int[dp.length];
      for (int j = 0; j < nextDp.length; ++j) {
        for (int k = 0; k <= j; ++k) {
          nextDp[j] = addMod(nextDp[j], dp[k]);
        }
      }

      dp = nextDp;
    }

    return Arrays.stream(dp).reduce(Main::addMod).getAsInt();
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }
}