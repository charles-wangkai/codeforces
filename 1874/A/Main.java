import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, k));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b, int k) {
    Arrays.sort(a);
    Arrays.sort(b);

    List<State> states = new ArrayList<>();
    states.add(buildState(a, 0));

    Map<State, Integer> stateToIndex = new HashMap<>();
    stateToIndex.put(buildState(a, 0), 0);

    for (int round = 1; round <= k; ++round) {
      if (round % 2 == 1) {
        if (a[0] < b[b.length - 1]) {
          int temp = a[0];
          a[0] = b[b.length - 1];
          b[b.length - 1] = temp;

          Arrays.sort(a);
          Arrays.sort(b);
        }
      } else {
        if (b[0] < a[a.length - 1]) {
          int temp = b[0];
          b[0] = a[a.length - 1];
          a[a.length - 1] = temp;

          Arrays.sort(a);
          Arrays.sort(b);
        }
      }

      State state = buildState(a, round);
      if (stateToIndex.containsKey(state)) {
        int index = stateToIndex.get(state);

        return states.get((k - round) % (stateToIndex.size() - index) + index).valueSum();
      } else {
        states.add(state);
        stateToIndex.put(state, stateToIndex.size());
      }
    }

    return Arrays.stream(a).asLongStream().sum();
  }

  static State buildState(int[] a, int round) {
    return new State(
        Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(",")),
        round % 2,
        Arrays.stream(a).asLongStream().sum());
  }
}

record State(String values, int turn, long valueSum) {}
