import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(u, v));
    }

    sc.close();
  }

  static int solve(int[] u, int[] v) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    Set<Integer>[] adjSets = new Set[n];
    for (int i = 0; i < adjSets.length; ++i) {
      adjSets[i] = new HashSet<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjSets[u[i] - 1].add(v[i] - 1);
      adjSets[v[i] - 1].add(u[i] - 1);
    }

    SortedMap<Integer, Integer> degreeToCount = new TreeMap<>();
    for (int i = 0; i < adjSets.length; ++i) {
      updateMap(degreeToCount, adjSets[i].size(), 1);
    }

    int result = -1;
    for (int i = 0; i < n; ++i) {
      int[] involved =
          IntStream.concat(IntStream.of(i), adjSets[i].stream().mapToInt(Integer::intValue))
              .toArray();

      for (int node : involved) {
        updateMap(degreeToCount, adjSets[node].size(), -1);
      }

      for (int adj : adjSets[i]) {
        updateMap(degreeToCount, adjSets[adj].size() - 1, 1);
      }

      result =
          Math.max(
              result,
              adjSets[i].size() + (degreeToCount.isEmpty() ? -1 : (degreeToCount.lastKey() - 1)));

      for (int adj : adjSets[i]) {
        updateMap(degreeToCount, adjSets[adj].size() - 1, -1);
      }

      for (int node : involved) {
        updateMap(degreeToCount, adjSets[node].size(), 1);
      }
    }

    return result;
  }

  static void updateMap(SortedMap<Integer, Integer> degreeToCount, int degree, int delta) {
    if (degree != 0) {
      degreeToCount.put(degree, degreeToCount.getOrDefault(degree, 0) + delta);
      degreeToCount.remove(degree, 0);
    }
  }
}