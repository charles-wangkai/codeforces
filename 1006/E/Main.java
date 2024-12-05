import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] p = new int[n - 1];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }
    int[] u = new int[q];
    int[] k = new int[q];
    for (int i = 0; i < q; ++i) {
      u[i] = sc.nextInt();
      k[i] = sc.nextInt();
    }

    System.out.println(solve(p, u, k));

    sc.close();
  }

  static String solve(int[] p, int[] u, int[] k) {
    int n = p.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[n];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < p.length; ++i) {
      childLists[p[i] - 1].add(i + 1);
    }
    for (List<Integer> childList : childLists) {
      Collections.sort(childList);
    }

    List<Integer> sequence = new ArrayList<>();
    int[] subtreeSizes = new int[n];
    search(sequence, subtreeSizes, childLists, 0);

    Map<Integer, Integer> nodeToIndex =
        IntStream.range(0, sequence.size())
            .boxed()
            .collect(Collectors.toMap(sequence::get, i -> i));

    return IntStream.range(0, u.length)
        .map(
            i ->
                (k[i] <= subtreeSizes[u[i] - 1])
                    ? (sequence.get(nodeToIndex.get(u[i] - 1) + k[i] - 1) + 1)
                    : -1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static void search(
      List<Integer> sequence, int[] subtreeSizes, List<Integer>[] childLists, int node) {
    sequence.add(node);

    subtreeSizes[node] = 1;
    for (int child : childLists[node]) {
      search(sequence, subtreeSizes, childLists, child);
      subtreeSizes[node] += subtreeSizes[child];
    }
  }
}