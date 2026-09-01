import java.util.ArrayList;
import java.util.Comparator;
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
      int st = sc.nextInt();
      int en = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(u, v, st, en));
    }

    sc.close();
  }

  static String solve(int[] u, int[] v, int st, int en) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    int[] distances = new int[n];
    search(distances, adjLists, -1, en - 1, 0);

    return IntStream.range(0, distances.length)
        .boxed()
        .sorted(Comparator.<Integer, Integer>comparing(i -> distances[i]).reversed())
        .map(i -> i + 1)
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static void search(
      int[] distances, List<Integer>[] adjLists, int parent, int node, int distance) {
    distances[node] = distance;

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(distances, adjLists, node, adj, distance + 1);
      }
    }
  }
}