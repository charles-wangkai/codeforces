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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int[] dp = new int[a.length + 1];
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayList<>());
      valueToIndices.get(a[i]).add(i);

      dp[i + 1] = dp[i];

      List<Integer> indices = valueToIndices.get(a[i]);
      if (indices.size() >= a[i]) {
        dp[i + 1] = Math.max(dp[i + 1], a[i] + dp[indices.get(indices.size() - a[i])]);
      }
    }

    return dp[dp.length - 1];
  }
}