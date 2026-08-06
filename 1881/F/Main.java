import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[k];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(u, v, a));
    }

    sc.close();
  }

  static int solve(int[] u, int[] v, int[] a) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    boolean[] marked = new boolean[n];
    for (int ai : a) {
      marked[ai - 1] = true;
    }

    int[] subtreeMaxDistances = new int[n];
    Arrays.fill(subtreeMaxDistances, -1);
    search1(subtreeMaxDistances, adjLists, marked, -1, 0);

    return search2(adjLists, marked, subtreeMaxDistances, -1, -1, 0);
  }

  static int search2(
      List<Integer>[] adjLists,
      boolean[] marked,
      int[] subtreeMaxDistances,
      int upMaxDistance,
      int parent,
      int node) {
    int result = Math.max(upMaxDistance, subtreeMaxDistances[node]);

    SortedMap<Integer, Integer> distanceToCount = new TreeMap<>();
    if (upMaxDistance != -1) {
      updateMap(distanceToCount, upMaxDistance, 1);
    }
    if (marked[node]) {
      updateMap(distanceToCount, 0, 1);
    }
    for (int adj : adjLists[node]) {
      if (adj != parent && subtreeMaxDistances[adj] != -1) {
        updateMap(distanceToCount, subtreeMaxDistances[adj] + 1, 1);
      }
    }

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        if (subtreeMaxDistances[adj] != -1) {
          updateMap(distanceToCount, subtreeMaxDistances[adj] + 1, -1);
        }

        result =
            Math.min(
                result,
                search2(
                    adjLists,
                    marked,
                    subtreeMaxDistances,
                    distanceToCount.isEmpty() ? -1 : (distanceToCount.lastKey() + 1),
                    node,
                    adj));

        if (subtreeMaxDistances[adj] != -1) {
          updateMap(distanceToCount, subtreeMaxDistances[adj] + 1, 1);
        }
      }
    }

    return result;
  }

  static void updateMap(SortedMap<Integer, Integer> distanceToCount, int distance, int delta) {
    distanceToCount.put(distance, distanceToCount.getOrDefault(distance, 0) + delta);
    distanceToCount.remove(distance, 0);
  }

  static void search1(
      int[] subtreeMaxDistances, List<Integer>[] adjLists, boolean[] marked, int parent, int node) {
    if (marked[node]) {
      subtreeMaxDistances[node] = Math.max(subtreeMaxDistances[node], 0);
    }

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search1(subtreeMaxDistances, adjLists, marked, node, adj);

        if (subtreeMaxDistances[adj] != -1) {
          subtreeMaxDistances[node] =
              Math.max(subtreeMaxDistances[node], subtreeMaxDistances[adj] + 1);
        }
      }
    }
  }
}