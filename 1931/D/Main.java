import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x, y));
    }

    sc.close();
  }

  static long solve(int[] a, int x, int y) {
    Map<State, Integer> stateToCount = new HashMap<>();
    for (int ai : a) {
      State state = new State(ai % x, ai % y);
      stateToCount.put(state, stateToCount.getOrDefault(state, 0) + 1);
    }

    long result = 0;
    for (int ai : a) {
      State state = new State(ai % x, ai % y);
      State other = new State((x - state.xMod()) % x, state.yMod());
      if (stateToCount.containsKey(other)) {
        result += stateToCount.get(other) - (other.equals(state) ? 1 : 0);
      }
    }
    result /= 2;

    return result;
  }
}

record State(int xMod, int yMod) {}
