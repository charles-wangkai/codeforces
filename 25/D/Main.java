import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    int[] parents = new int[n];
    Arrays.fill(parents, -1);
    for (int i = 0; i < a.length; ++i) {
      int root1 = findRoot(parents, a[i] - 1);
      int root2 = findRoot(parents, b[i] - 1);
      if (root1 == root2) {
        closed.add(i);
      } else {
        parents[root2] = root1;
      }
    }

    int[] roots = IntStream.range(0, n).map(i -> findRoot(parents, i)).distinct().toArray();

    return String.format(
        "%d\n%s",
        closed.size(),
        IntStream.range(0, closed.size())
            .mapToObj(
                i ->
                    String.format(
                        "%d %d %d %d",
                        a[closed.get(i)], b[closed.get(i)], roots[i] + 1, roots[i + 1] + 1))
            .collect(Collectors.joining("\n")));
  }

  static int findRoot(int[] parents, int node) {
    if (parents[node] == -1) {
      return node;
    }

    parents[node] = findRoot(parents, parents[node]);

    return parents[node];
  }
}