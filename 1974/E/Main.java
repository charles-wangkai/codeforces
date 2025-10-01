import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int m = sc.nextInt();
      int x = sc.nextInt();
      int[] c = new int[m];
      int[] h = new int[m];
      for (int i = 0; i < m; ++i) {
        c[i] = sc.nextInt();
        h[i] = sc.nextInt();
      }

      System.out.println(solve(c, h, x));
    }

    sc.close();
  }

  static int solve(int[] c, int[] h, int x) {
    Map<Integer, Long> happinessToMoney = Map.of(0, 0L);
    for (int i = 0; i < c.length; ++i) {
      Map<Integer, Long> nextHappinessToMoney = new HashMap<>(happinessToMoney);
      for (int happiness : happinessToMoney.keySet()) {
        if (happinessToMoney.get(happiness) >= c[i]) {
          nextHappinessToMoney.put(
              happiness + h[i],
              Math.max(
                  nextHappinessToMoney.getOrDefault(happiness + h[i], 0L),
                  happinessToMoney.get(happiness) - c[i]));
        }
      }
      happinessToMoney = nextHappinessToMoney;

      for (int happiness : happinessToMoney.keySet()) {
        happinessToMoney.put(happiness, happinessToMoney.get(happiness) + x);
      }
    }

    return happinessToMoney.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();
  }
}