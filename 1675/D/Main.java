import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static String solve(int[] p) {
    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[p.length];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    int root = -1;
    for (int i = 0; i < p.length; ++i) {
      if (p[i] == i) {
        root = i;
      } else {
        childLists[p[i]].add(i);
      }
    }

    List<List<Integer>> paths = new ArrayList<>();
    search(paths, childLists, root, null);

    return String.format(
        "%d\n%s",
        paths.size(),
        paths.stream()
            .map(
                path ->
                    String.format(
                        "%d\n%s",
                        path.size(),
                        path.stream().map(String::valueOf).collect(Collectors.joining(" "))))
            .collect(Collectors.joining("\n")));
  }

  static void search(
      List<List<Integer>> paths, List<Integer>[] childLists, int node, List<Integer> path) {
    if (path == null) {
      path = new ArrayList<>();
      paths.add(path);
    }
    path.add(node + 1);

    for (int i = 0; i < childLists[node].size(); ++i) {
      search(paths, childLists, childLists[node].get(i), (i == 0) ? path : null);
    }
  }
}
