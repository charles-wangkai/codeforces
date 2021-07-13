// https://blog.csdn.net/qq_33330876/article/details/53892594
// https://www.cnblogs.com/xuesu/p/3978294.html

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] C = new int[N];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }

    System.out.println(solve(C, M));

    sc.close();
  }

  static int solve(int[] C, int M) {
    int N = C.length;

    int[][] dp = new int[N][M];
    for (int i = 0; i < M; ++i) {
      for (int j = 0; j < i; ++j) {
        dp[i][i - j] = C[i] + C[j];
      }
    }

    for (int j = 1; j < N; ++j) {
      int minPrev = Integer.MAX_VALUE;
      for (int i = Math.min(N, j + M) - 1; i > j && i >= M; --i) {
        minPrev = Math.min(minPrev, dp[j][j - (i - M)]);
        dp[i][i - j] = minPrev + C[i];
      }
    }

    int result = Integer.MAX_VALUE;
    for (int i = N - M + 1; i < N; ++i) {
      for (int j = Math.min(M - 1, i - N + M); j >= 1; --j) {
        result = Math.min(result, dp[i][j]);
      }
    }

    return result;
  }
}
