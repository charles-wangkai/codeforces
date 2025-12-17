import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] p = new int[n - 1];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println(solve(p));

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

    List<Integer> depthCounts = new ArrayList<>();
    search(depthCounts, childLists, 0, 0);

    return depthCounts.stream().mapToInt(depthCount -> depthCount % 2).sum();
  }

  static void search(List<Integer> depthCounts, List<Integer>[] childLists, int depth, int node) {
    if (depthCounts.size() == depth) {
      depthCounts.add(0);
    }
    depthCounts.set(depth, depthCounts.get(depth) + 1);

    for (int child : childLists[node]) {
      search(depthCounts, childLists, depth + 1, child);
    }
  }
}