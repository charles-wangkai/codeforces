import java.util.ArrayList;
import java.util.Arrays;
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
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt() - 1;
        v[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(u, v));
    }

    sc.close();
  }

  static String solve(int[] u, int[] v) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[u[i]].add(i);
      edgeLists[v[i]].add(i);
    }

    if (Arrays.stream(edgeLists).anyMatch(edgeList -> edgeList.size() >= 3)) {
      return "-1";
    }

    int start =
        IntStream.range(0, edgeLists.length)
            .filter(i -> edgeLists[i].size() == 1)
            .findAny()
            .getAsInt();

    int[] weights = new int[u.length];
    search(weights, u, v, edgeLists, start, 2);

    return Arrays.stream(weights).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void search(
      int[] weights, int[] u, int[] v, List<Integer>[] edgeLists, int node, int weight) {
    for (int edge : edgeLists[node]) {
      if (weights[edge] == 0) {
        weights[edge] = weight;

        search(weights, u, v, edgeLists, (node == u[edge]) ? v[edge] : u[edge], 5 - weight);
      }
    }
  }
}