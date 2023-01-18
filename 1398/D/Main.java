import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final int LIMIT = 201;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();
    int G = sc.nextInt();
    int B = sc.nextInt();
    int[] r = new int[R];
    for (int i = 0; i < r.length; ++i) {
      r[i] = sc.nextInt();
    }
    int[] g = new int[G];
    for (int i = 0; i < g.length; ++i) {
      g[i] = sc.nextInt();
    }
    int[] b = new int[B];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(r, g, b));

    sc.close();
  }

  static int solve(int[] r, int[] g, int[] b) {
    r = reverseSort(r);
    g = reverseSort(g);
    b = reverseSort(b);

    int result = -1;
    Map<Integer, Integer> stateToArea = Map.of(0, 0);
    while (!stateToArea.isEmpty()) {
      Map<Integer, Integer> nextStateToArea = new HashMap<>();
      for (int state : stateToArea.keySet()) {
        result = Math.max(result, stateToArea.get(state));

        int rIndex = state / (LIMIT * LIMIT);
        int gIndex = state % (LIMIT * LIMIT) / LIMIT;
        int bIndex = state % LIMIT;

        if (rIndex != r.length && gIndex != g.length) {
          int nextState = encode(rIndex + 1, gIndex + 1, bIndex);
          nextStateToArea.put(
              nextState,
              Math.max(
                  nextStateToArea.getOrDefault(nextState, -1),
                  stateToArea.get(state) + r[rIndex] * g[gIndex]));
        }
        if (gIndex != g.length && bIndex != b.length) {
          int nextState = encode(rIndex, gIndex + 1, bIndex + 1);
          nextStateToArea.put(
              nextState,
              Math.max(
                  nextStateToArea.getOrDefault(nextState, -1),
                  stateToArea.get(state) + g[gIndex] * b[bIndex]));
        }
        if (bIndex != b.length && rIndex != r.length) {
          int nextState = encode(rIndex + 1, gIndex, bIndex + 1);
          nextStateToArea.put(
              nextState,
              Math.max(
                  nextStateToArea.getOrDefault(nextState, -1),
                  stateToArea.get(state) + b[bIndex] * r[rIndex]));
        }
      }

      stateToArea = nextStateToArea;
    }

    return result;
  }

  static int encode(int rIndex, int gIndex, int bIndex) {
    return rIndex * LIMIT * LIMIT + gIndex * LIMIT + bIndex;
  }

  static int[] reverseSort(int[] x) {
    return Arrays.stream(x)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
