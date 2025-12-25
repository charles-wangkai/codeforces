import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(n, a, b));

    sc.close();
  }

  static String solve(int n, int[] a, int[] b) {
    int[] parents = new int[n];
    Arrays.fill(parents, -1);

    for (int i = 0; i < a.length; ++i) {
      int root1 = findRoot(parents, a[i] - 1);
      int root2 = findRoot(parents, b[i] - 1);
      if (root1 != root2) {
        parents[root2] = root1;
      }
    }

    Map<Integer, List<Integer>> rootToGroup = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      int root = findRoot(parents, i);

      rootToGroup.putIfAbsent(root, new ArrayList<>());
      rootToGroup.get(root).add(i);
    }

    @SuppressWarnings("unchecked")
    Queue<List<Integer>>[] groupQueues = new Queue[4];
    for (int i = 0; i < groupQueues.length; ++i) {
      groupQueues[i] = new ArrayDeque<>();
    }

    for (List<Integer> group : rootToGroup.values()) {
      if (group.size() > 3) {
        return "-1";
      }

      groupQueues[group.size()].offer(group);
    }

    List<List<Integer>> teams = new ArrayList<>();

    while (!groupQueues[3].isEmpty()) {
      teams.add(groupQueues[3].poll());
    }

    while (!groupQueues[2].isEmpty()) {
      if (groupQueues[1].isEmpty()) {
        return "-1";
      }

      List<Integer> team = new ArrayList<>();
      team.addAll(groupQueues[2].poll());
      team.addAll(groupQueues[1].poll());

      teams.add(team);
    }

    while (!groupQueues[1].isEmpty()) {
      List<Integer> team = new ArrayList<>();
      team.addAll(groupQueues[1].poll());
      team.addAll(groupQueues[1].poll());
      team.addAll(groupQueues[1].poll());

      teams.add(team);
    }

    return teams.stream()
        .map(
            team ->
                team.stream().map(x -> x + 1).map(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }

  static int findRoot(int[] parents, int node) {
    if (parents[node] == -1) {
      return node;
    }

    parents[node] = findRoot(parents, parents[node]);

    return parents[node];
  }
}