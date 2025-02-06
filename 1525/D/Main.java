import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    int[] zeroIndices = IntStream.range(0, a.length).filter(i -> a[i] == 0).toArray();
    int[] oneIndices = IntStream.range(0, a.length).filter(i -> a[i] == 1).toArray();

    int[] dp = new int[a.length + 1];
    for (int oneIndex : oneIndices) {
      int[] nextDp = new int[dp.length];
      Arrays.fill(nextDp, Integer.MAX_VALUE);

      for (int zeroIndex : zeroIndices) {
        if (dp[zeroIndex] != Integer.MAX_VALUE) {
          nextDp[zeroIndex + 1] = Math.abs(oneIndex - zeroIndex) + dp[zeroIndex];
        }
      }
      for (int i = 1; i < nextDp.length; ++i) {
        nextDp[i] = Math.min(nextDp[i], nextDp[i - 1]);
      }

      dp = nextDp;
    }

    return dp[dp.length - 1];
  }
}