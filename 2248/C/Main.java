import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[2 * n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    int n = a.length;

    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayList<>());
      valueToIndices.get(a[i]).add(i);
    }

    long[] dp = new long[n + 1];
    for (int i = 1; i < dp.length; ++i) {
      dp[i] = dp[i - 1] + 1;

      List<Integer> indices = valueToIndices.get(a[i - 1]);
      if (i - 1 == indices.get(1)) {
        dp[i] =
            Math.max(
                dp[i],
                dp[indices.get(0)]
                    + (indices.get(1) - indices.get(0) + 1L)
                        * (indices.get(1) - indices.get(0) + 1));
      }
    }

    return dp[n];
  }
}