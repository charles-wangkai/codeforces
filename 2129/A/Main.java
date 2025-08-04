import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    List<Integer> selected = new ArrayList<>();
    Map<Integer, Integer> nodeToParent = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      int root1 = findRoot(nodeToParent, a[i]);
      int root2 = findRoot(nodeToParent, b[i]);
      if (root1 != root2) {
        selected.add(i + 1);
        nodeToParent.put(root2, root1);
      }
    }

    return "%d\n%s"
        .formatted(
            selected.size(),
            selected.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int findRoot(Map<Integer, Integer> nodeToParent, int node) {
    if (!nodeToParent.containsKey(node)) {
      return node;
    }

    nodeToParent.put(node, findRoot(nodeToParent, nodeToParent.get(node)));

    return nodeToParent.get(node);
  }
}