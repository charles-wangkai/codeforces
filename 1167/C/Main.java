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
    int m = sc.nextInt();
    int[][] groups = new int[m][];
    for (int i = 0; i < groups.length; i++) {
      int k = sc.nextInt();
      groups[i] = new int[k];
      for (int j = 0; j < groups[i].length; j++) {
        groups[i][j] = sc.nextInt() - 1;
      }
    }
    System.out.print(solve(n, groups));

    sc.close();
  }

  static String solve(int n, int[][] groups) {
    Dsu dsu = new Dsu(n);
    for (int[] group : groups) {
      for (int i = 0; i < group.length - 1; i++) {
        dsu.union(group[i], group[i + 1]);
      }
    }

    return IntStream.range(0, n)
        .map(dsu::getSize)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
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
