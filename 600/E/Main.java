import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] c = new int[n];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }
    int[] x = new int[n - 1];
    int[] y = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      x[i] = sc.nextInt() - 1;
      y[i] = sc.nextInt() - 1;
    }

    System.out.println(solve(c, x, y));

    sc.close();
  }

  static String solve(int[] c, int[] x, int[] y) {
    int n = c.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < x.length; ++i) {
      adjLists[x[i]].add(y[i]);
      adjLists[y[i]].add(x[i]);
    }

    long[] dominatingSums = new long[n];
    search(c, adjLists, dominatingSums, new boolean[n], 0);

    return Arrays.stream(dominatingSums).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static Outcome search(
      int[] c, List<Integer>[] adjLists, long[] dominatingSums, boolean[] visited, int node) {
    visited[node] = true;

    Map<Integer, Integer> colorToFreq = new HashMap<>();
    colorToFreq.put(c[node], 1);

    SortedMap<Integer, Long> freqToColorSum = new TreeMap<>();
    freqToColorSum.put(1, (long) c[node]);

    Outcome outcome = new Outcome(colorToFreq, freqToColorSum);

    for (int adj : adjLists[node]) {
      if (!visited[adj]) {
        outcome = merge(outcome, search(c, adjLists, dominatingSums, visited, adj));
      }
    }

    dominatingSums[node] = outcome.freqToColorSum().get(outcome.freqToColorSum().lastKey());

    return outcome;
  }

  static Outcome merge(Outcome outcome1, Outcome outcome2) {
    if (outcome1.colorToFreq().size() < outcome2.colorToFreq().size()) {
      return merge(outcome2, outcome1);
    }

    for (int color : outcome2.colorToFreq().keySet()) {
      int newFreq = outcome2.colorToFreq().get(color);

      if (outcome1.colorToFreq().containsKey(color)) {
        updateMap(outcome1.freqToColorSum(), outcome1.colorToFreq().get(color), -color);
        newFreq += outcome1.colorToFreq().remove(color);
      }

      outcome1.colorToFreq().put(color, newFreq);
      updateMap(outcome1.freqToColorSum(), newFreq, color);
    }

    return outcome1;
  }

  static void updateMap(SortedMap<Integer, Long> freqToColorSum, int freq, int delta) {
    freqToColorSum.put(freq, freqToColorSum.getOrDefault(freq, 0L) + delta);
    freqToColorSum.remove(freq, 0L);
  }
}

record Outcome(Map<Integer, Integer> colorToFreq, SortedMap<Integer, Long> freqToColorSum) {}
