import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(u, v));
    }

    sc.close();
  }

  static String solve(int[] u, int[] v) {
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

    OptionalInt node = IntStream.range(0, n).filter(i -> adjLists[i].size() == 2).findAny();
    if (node.isEmpty()) {
      return "NO";
    }

    List<String> pairs = new ArrayList<>();

    pairs.add("%d %d".formatted(node.getAsInt() + 1, adjLists[node.getAsInt()].get(0) + 1));
    search(pairs, adjLists, node.getAsInt(), adjLists[node.getAsInt()].get(0), true);

    pairs.add("%d %d".formatted(adjLists[node.getAsInt()].get(1) + 1, node.getAsInt() + 1));
    search(pairs, adjLists, node.getAsInt(), adjLists[node.getAsInt()].get(1), false);

    return "YES\n%s".formatted(String.join("\n", pairs));
  }

  static void search(
      List<String> pairs, List<Integer>[] adjLists, int from, int node, boolean inOrOut) {
    for (int adj : adjLists[node]) {
      if (adj != from) {
        if (inOrOut) {
          pairs.add("%d %d".formatted(adj + 1, node + 1));
        } else {
          pairs.add("%d %d".formatted(node + 1, adj + 1));
        }

        search(pairs, adjLists, node, adj, !inOrOut);
      }
    }
  }
}