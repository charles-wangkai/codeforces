import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int h = sc.nextInt();
    int l = sc.nextInt();
    int r = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, h, l, r));

    sc.close();
  }

  static int solve(int[] a, int h, int l, int r) {
    int[] dp = new int[h];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int ai : a) {
      int[] nextDp = new int[h];
      Arrays.fill(nextDp, -1);
      for (int i = 0; i < dp.length; ++i) {
        if (dp[i] != -1) {
          for (int j = ai - 1; j <= ai; ++j) {
            int next = (i + j) % h;
            nextDp[next] = Math.max(nextDp[next], dp[i] + ((next >= l && next <= r) ? 1 : 0));
          }
        }
      }

      dp = nextDp;
    }

    return Arrays.stream(dp).max().getAsInt();
  }
}
