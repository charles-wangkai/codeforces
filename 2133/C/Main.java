import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      Map<Integer, List<Integer>> lengthToNodes = new HashMap<>();
      for (int node = 1; node <= n; ++node) {
        int length = query(sc, node, IntStream.rangeClosed(1, n).toArray());

        lengthToNodes.putIfAbsent(length, new ArrayList<>());
        lengthToNodes.get(length).add(node);
      }

      List<Integer> v = new ArrayList<>();
      int length = lengthToNodes.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();
      int node = lengthToNodes.get(length).getFirst();
      while (true) {
        v.add(node);

        if (length == 1) {
          break;
        }

        for (int next : lengthToNodes.get(length - 1)) {
          if (query(sc, node, new int[] {node, next}) == 2) {
            node = next;

            break;
          }
        }

        --length;
      }

      System.out.println(
          "! %d %s"
              .formatted(
                  v.size(), v.stream().map(String::valueOf).collect(Collectors.joining(" "))));
      System.out.flush();
    }

    sc.close();
  }

  static int query(Scanner sc, int x, int[] s) {
    System.out.println(
        "? %d %d %s"
            .formatted(
                x,
                s.length,
                Arrays.stream(s).mapToObj(String::valueOf).collect(Collectors.joining(" "))));
    System.out.flush();

    return sc.nextInt();
  }
}