import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n - 1];
    int[] b = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    int n = a.length + 1;

    List<Integer> closed = new ArrayList<>();
    Dsu dsu = new Dsu(n);
    for (int i = 0; i < a.length; ++i) {
      int leader1 = dsu.find(a[i] - 1);
      int leader2 = dsu.find(b[i] - 1);
      if (leader1 == leader2) {
        closed.add(i);
      } else {
        dsu.union(leader1, leader2);
      }
    }

    int[] leaders =
        dsu.buildLeaderToGroup().keySet().stream().mapToInt(Integer::intValue).toArray();

    return "%d\n%s"
        .formatted(
            closed.size(),
            IntStream.range(0, closed.size())
                .mapToObj(
                    i ->
                        "%d %d %d %d"
                            .formatted(
                                a[closed.get(i)],
                                b[closed.get(i)],
                                leaders[i] + 1,
                                leaders[i + 1] + 1))
                .collect(Collectors.joining("\n")));
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
