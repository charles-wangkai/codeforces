import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n - 1];
      int[] y = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static String solve(int[] x, int[] y) {
    int n = x.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < x.length; ++i) {
      adjLists[x[i] - 1].add(y[i] - 1);
      adjLists[y[i] - 1].add(x[i] - 1);
    }

    int[] subtreeSizes = new int[n];
    int[] restMaxSizes = new int[n];
    search(subtreeSizes, restMaxSizes, adjLists, -1, 0);

    int minRestMaxSize = Arrays.stream(restMaxSizes).min().getAsInt();
    int[] centroids =
        IntStream.range(0, restMaxSizes.length)
            .filter(i -> restMaxSizes[i] == minRestMaxSize)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> adjLists[i].size()).reversed())
            .mapToInt(Integer::intValue)
            .toArray();
    if (centroids.length == 1) {
      return "%d %d\n%d %d"
          .formatted(
              centroids[0] + 1,
              adjLists[centroids[0]].get(0) + 1,
              centroids[0] + 1,
              adjLists[centroids[0]].get(0) + 1);
    }

    int other = adjLists[centroids[0]].stream().filter(adj -> adj != centroids[1]).findAny().get();

    return "%d %d\n%d %d".formatted(centroids[0] + 1, other + 1, centroids[1] + 1, other + 1);
  }

  static void search(
      int[] subtreeSizes, int[] restMaxSizes, List<Integer>[] adjLists, int parent, int node) {
    int n = adjLists.length;

    subtreeSizes[node] = 1;
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(subtreeSizes, restMaxSizes, adjLists, node, adj);

        subtreeSizes[node] += subtreeSizes[adj];
        restMaxSizes[node] = Math.max(restMaxSizes[node], subtreeSizes[adj]);
      }
    }
    restMaxSizes[node] = Math.max(restMaxSizes[node], n - subtreeSizes[node]);
  }
}