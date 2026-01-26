import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    sc.nextLine();
    String[] events = new String[q];
    for (int i = 0; i < events.length; ++i) {
      events[i] = sc.nextLine();
    }

    System.out.println(solve(events));

    sc.close();
  }

  static String solve(String[] events) {
    List<Long> result = new ArrayList<>();
    Map<Edge, Long> edgeToCost = new HashMap<>();
    for (String event : events) {
      String[] fields = event.split(" ");
      long v = Long.parseLong(fields[1]);
      long u = Long.parseLong(fields[2]);

      List<Edge> edges = findEdges(v, u);

      if (fields[0].equals("1")) {
        int w = Integer.parseInt(fields[3]);

        for (Edge edge : edges) {
          edgeToCost.put(edge, edgeToCost.getOrDefault(edge, 0L) + w);
        }
      } else {
        result.add(edges.stream().mapToLong(edge -> edgeToCost.getOrDefault(edge, 0L)).sum());
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static List<Edge> findEdges(long v, long u) {
    List<Long> vNodes = buildNodes(v);
    List<Long> uNodes = buildNodes(u);

    int index = 0;
    while (index != vNodes.size() - 1
        && index != uNodes.size() - 1
        && vNodes.get(index + 1).equals(uNodes.get(index + 1))) {
      ++index;
    }

    return Stream.concat(
            IntStream.range(index, vNodes.size() - 1)
                .mapToObj(i -> new Edge(vNodes.get(i), vNodes.get(i + 1))),
            IntStream.range(index, uNodes.size() - 1)
                .mapToObj(i -> new Edge(uNodes.get(i), uNodes.get(i + 1))))
        .toList();
  }

  static List<Long> buildNodes(long node) {
    List<Long> result = new ArrayList<>();
    while (true) {
      result.add(node);
      if (node == 1) {
        break;
      }

      node /= 2;
    }
    Collections.reverse(result);

    return result;
  }
}

record Edge(long node1, long node2) {}
