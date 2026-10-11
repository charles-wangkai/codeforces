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

    int n = sc.nextInt();
    int[] u = new int[n - 1];
    int[] v = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(u, v));

    sc.close();
  }

  static String solve(int[] u, int[] v) {
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

    int[] subtreeMaxDistances = new int[n];
    search1(subtreeMaxDistances, adjLists, -1, 0);

    int[] maxDistances = new int[n];
    search2(maxDistances, adjLists, subtreeMaxDistances, 0, -1, 0);

    Map<Integer, Integer> maxDistanceToCount = new HashMap<>();
    for (int maxDistance : maxDistances) {
      maxDistanceToCount.put(maxDistance, maxDistanceToCount.getOrDefault(maxDistance, 0) + 1);
    }

    int totalMaxDistance =
        maxDistanceToCount.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();

    int[] result = new int[n];
    Arrays.fill(result, n);

    int componentNum = n + 1;
    for (int i = totalMaxDistance - 1; i >= 0; --i) {
      componentNum -= maxDistanceToCount.getOrDefault(i + 1, 0);
      result[i] = componentNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void search2(
      int[] maxDistances,
      List<Integer>[] adjLists,
      int[] subtreeMaxDistances,
      int upMaxDistance,
      int parent,
      int node) {
    maxDistances[node] = Math.max(upMaxDistance, subtreeMaxDistances[node]);

    int maxDistance1 = upMaxDistance;
    int maxDistance2 = 0;

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        int distance = subtreeMaxDistances[adj] + 1;

        if (distance > maxDistance1) {
          maxDistance2 = maxDistance1;
          maxDistance1 = distance;
        } else {
          maxDistance2 = Math.max(maxDistance2, distance);
        }
      }
    }

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search2(
            maxDistances,
            adjLists,
            subtreeMaxDistances,
            (subtreeMaxDistances[adj] + 1 == maxDistance1)
                ? (maxDistance2 + 1)
                : (maxDistance1 + 1),
            node,
            adj);
      }
    }
  }

  static void search1(int[] subtreeMaxDistances, List<Integer>[] adjLists, int parent, int node) {
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search1(subtreeMaxDistances, adjLists, node, adj);
        subtreeMaxDistances[node] =
            Math.max(subtreeMaxDistances[node], subtreeMaxDistances[adj] + 1);
      }
    }
  }
}