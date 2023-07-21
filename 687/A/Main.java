import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; i++) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }
    System.out.print(solve(n, u, v));

    sc.close();
  }

  static String solve(int n, int[] u, int[] v) {
    List<Integer>[] adjacentLists = initLists(n);

    for (int i = 0; i < u.length; i++) {
      adjacentLists[u[i] - 1].add(v[i] - 1);
      adjacentLists[v[i] - 1].add(u[i] - 1);
    }

    List<Integer>[] vertices = initLists(2);
    Map<Integer, Integer> indexToGroup = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (!indexToGroup.containsKey(i) && !search(adjacentLists, indexToGroup, i, 0)) {
        return "-1";
      }

      vertices[indexToGroup.get(i)].add(i);
    }

    return IntStream.range(0, vertices.length)
        .mapToObj(
            i ->
                String.format(
                    "%d\n%s",
                    vertices[i].size(),
                    vertices[i].stream()
                        .map(x -> String.valueOf(x + 1))
                        .collect(Collectors.joining(" "))))
        .collect(Collectors.joining("\n"));
  }

  static List<Integer>[] initLists(int size) {
    @SuppressWarnings("unchecked")
    List<Integer>[] result = new List[size];
    for (int i = 0; i < result.length; i++) {
      result[i] = new ArrayList<>();
    }
    return result;
  }

  static boolean search(
      List<Integer>[] adjacentLists, Map<Integer, Integer> indexToGroup, int index, int group) {
    if (indexToGroup.containsKey(index)) {
      return indexToGroup.get(index) == group;
    }

    indexToGroup.put(index, group);

    for (int adjacent : adjacentLists[index]) {
      if (!search(adjacentLists, indexToGroup, adjacent, 1 - group)) {
        return false;
      }
    }

    return true;
  }
}
