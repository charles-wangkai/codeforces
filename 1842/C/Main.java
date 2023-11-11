import java.util.HashMap;
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
    Map<Integer, Integer> valueToMinRest = new HashMap<>();
    int[] dp = new int[a.length];
    for (int i = 0; i < dp.length; ++i) {
      dp[i] =
          Math.min(
              ((i == 0) ? 0 : dp[i - 1]) + 1, valueToMinRest.getOrDefault(a[i], Integer.MAX_VALUE));

      valueToMinRest.put(
          a[i],
          Math.min(valueToMinRest.getOrDefault(a[i], Integer.MAX_VALUE), (i == 0) ? 0 : dp[i - 1]));
    }

    return a.length - dp[dp.length - 1];
  }
}
