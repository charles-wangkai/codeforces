import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n - 1];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    int n = p.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[n];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < p.length; ++i) {
      childLists[p[i] - 1].add(i + 1);
    }

    return search(childLists, 0).guildNum();
  }

  static Outcome search(List<Integer>[] childLists, int node) {
    int guildNum = 1;
    int maxDepth = 0;

    List<Integer> subtreeMaxDepths = new ArrayList<>();
    for (int child : childLists[node]) {
      Outcome outcome = search(childLists, child);

      subtreeMaxDepths.add(outcome.maxDepth());

      guildNum += outcome.guildNum();
      maxDepth = Math.max(maxDepth, outcome.maxDepth() + 1);
    }

    if (subtreeMaxDepths.size() >= 2) {
      Collections.sort(subtreeMaxDepths, Comparator.reverseOrder());
      guildNum += subtreeMaxDepths.get(1) + 1;
    }

    return new Outcome(guildNum, maxDepth);
  }
}

record Outcome(int guildNum, int maxDepth) {}
