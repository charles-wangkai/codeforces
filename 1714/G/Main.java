import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n - 1];
      int[] a = new int[n - 1];
      int[] b = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        p[i] = sc.nextInt();
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }

      System.out.println(solve(p, a, b));
    }

    sc.close();
  }

  static String solve(int[] p, int[] a, int[] b) {
    int n = p.length + 1;

    @SuppressWarnings("unchecked")
    List<Edge>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < p.length; ++i) {
      edgeLists[p[i] - 1].add(new Edge(i + 1, a[i], b[i]));
    }

    int[] maxPrefixLengths = new int[n];
    search(maxPrefixLengths, edgeLists, 0, new ArrayList<>(), 0);

    return IntStream.range(1, maxPrefixLengths.length)
        .map(i -> maxPrefixLengths[i])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static void search(
      int[] maxPrefixLengths, List<Edge>[] edgeLists, long aSum, List<Long> bPrefixSums, int node) {
    maxPrefixLengths[node] = findMaxPrefixLength(bPrefixSums, aSum);

    for (Edge edge : edgeLists[node]) {
      bPrefixSums.add((bPrefixSums.isEmpty() ? 0 : bPrefixSums.getLast()) + edge.bCost());

      search(maxPrefixLengths, edgeLists, aSum + edge.aCost(), bPrefixSums, edge.child());

      bPrefixSums.removeLast();
    }
  }

  static int findMaxPrefixLength(List<Long> bPrefixSums, long aSum) {
    int index = -1;
    int lower = 0;
    int upper = bPrefixSums.size() - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (bPrefixSums.get(middle) <= aSum) {
        index = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return index + 1;
  }
}

record Edge(int child, int aCost, int bCost) {}
