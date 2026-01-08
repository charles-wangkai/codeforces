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
    Dsu dsu = new Dsu(n);
    for (int i = 0; i < a.length; ++i) {
      dsu.union(a[i] - 1, b[i] - 1);
    }

    @SuppressWarnings("unchecked")
    Queue<List<Integer>>[] groupQueues = new Queue[4];
    for (int i = 0; i < groupQueues.length; ++i) {
      groupQueues[i] = new ArrayDeque<>();
    }

    for (List<Integer> group : dsu.buildLeaderToGroup().values()) {
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
}

class Dsu {
  int[] parentOrSizes;

  Dsu(int n) {
    parentOrSizes = new int[n];
    Arrays.fill(parentOrSizes, -1);
  }

  int find(int a) {
    if (parentOrSizes[a] < 0) {
      return a;
    }

    parentOrSizes[a] = find(parentOrSizes[a]);

    return parentOrSizes[a];
  }

  void union(int a, int b) {
    int aLeader = find(a);
    int bLeader = find(b);
    if (aLeader != bLeader) {
      parentOrSizes[aLeader] += parentOrSizes[bLeader];
      parentOrSizes[bLeader] = aLeader;
    }
  }

  int getSize(int a) {
    return -parentOrSizes[find(a)];
  }

  Map<Integer, List<Integer>> buildLeaderToGroup() {
    Map<Integer, List<Integer>> leaderToGroup = new HashMap<>();
    for (int i = 0; i < parentOrSizes.length; ++i) {
      int leader = find(i);
      leaderToGroup.putIfAbsent(leader, new ArrayList<>());
      leaderToGroup.get(leader).add(i);
    }

    return leaderToGroup;
  }
}
