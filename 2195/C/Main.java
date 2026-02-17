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
    Map<Integer, Integer> dp = Map.of(0, 0);
    for (int ai : a) {
      Map<Integer, Integer> nextDp = new HashMap<>();
      for (int prev : dp.keySet()) {
        for (int curr = 1; curr <= 6; ++curr) {
          if (curr != prev && curr + prev != 7) {
            nextDp.put(
                curr,
                Math.min(
                    nextDp.getOrDefault(curr, Integer.MAX_VALUE),
                    dp.get(prev) + ((curr == ai) ? 0 : 1)));
          }
        }
      }

      dp = nextDp;
    }

    return dp.values().stream().mapToInt(Integer::intValue).min().getAsInt();
  }
}