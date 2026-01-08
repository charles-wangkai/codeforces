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
    String[] s = new String[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.next();
    }
    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String[] s) {
    Character[] letters =
        Arrays.stream(s)
            .flatMap(si -> si.chars().mapToObj(c -> (char) c))
            .distinct()
            .toArray(Character[]::new);
    Map<Character, Integer> letterToIndex =
        IntStream.range(0, letters.length)
            .boxed()
            .collect(Collectors.toMap(i -> letters[i], i -> i));

    Dsu dsu = new Dsu(letters.length);
    for (String si : s) {
      for (int i = 0; i < si.length() - 1; ++i) {
        dsu.union(letterToIndex.get(si.charAt(i)), letterToIndex.get(si.charAt(i + 1)));
      }
    }

    return dsu.buildLeaderToGroup().size();
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
