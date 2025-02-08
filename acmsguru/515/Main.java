// https://blog.csdn.net/weixin_30877493/article/details/95634578

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] a = new int[m];
    int[] b = new int[m];
    int[] t = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      a[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
      t[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    int[] c = new int[k];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < c.length; ++i) {
      c[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(n, a, b, t, c));
  }

  static String solve(int n, int[] a, int[] b, int[] t, int[] c) {
    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < a.length; ++i) {
      edgeLists[a[i] - 1].add(i);
      edgeLists[b[i] - 1].add(i);
    }

    Set<Integer> cities = Arrays.stream(c).map(ci -> ci - 1).boxed().collect(Collectors.toSet());

    int beginCity = findBeginCity(a, b, t, edgeLists, cities);
    int[] distances = computeDistances(a, b, t, edgeLists, beginCity);
    int[] fromEdges = buildFromEdges(a, b, t, edgeLists, cities, distances);

    List<Integer> path = new ArrayList<>();
    int node = cities.stream().max(Comparator.comparing(city -> distances[city])).get();
    while (fromEdges[node] != -1) {
      path.add(fromEdges[node]);
      node = getOther(a, b, fromEdges[node], node);
    }

    return String.format(
        "%d\n%s",
        path.size(),
        path.stream().map(edge -> edge + 1).map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int[] buildFromEdges(
      int[] a, int[] b, int[] t, List<Integer>[] edgeLists, Set<Integer> cities, int[] distances) {
    int n = distances.length;

    int[] result = new int[n];
    Arrays.fill(result, -1);

    int[] visitedCityNums = new int[n];

    int[] sortedNodes =
        IntStream.range(0, n)
            .boxed()
            .sorted(Comparator.comparing(i -> distances[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    for (int node : sortedNodes) {
      if (cities.contains(node)) {
        ++visitedCityNums[node];
      }

      for (int edge : edgeLists[node]) {
        int other = getOther(a, b, edge, node);

        if (distances[other] == distances[node] + t[edge]
            && visitedCityNums[node] > visitedCityNums[other]) {
          visitedCityNums[other] = visitedCityNums[node];
          result[other] = edge;
        }
      }
    }

    return result;
  }

  static int findBeginCity(
      int[] a, int[] b, int[] t, List<Integer>[] edgeLists, Set<Integer> cities) {
    int[] distances = computeDistances(a, b, t, edgeLists, cities.iterator().next());

    return cities.stream().max(Comparator.comparing(city -> distances[city])).get();
  }

  static int[] computeDistances(int[] a, int[] b, int[] t, List<Integer>[] edgeLists, int source) {
    int n = edgeLists.length;

    int[] result = new int[n];
    Arrays.fill(result, Integer.MAX_VALUE);

    PriorityQueue<Element> pq =
        new PriorityQueue<>(Comparator.comparing(element -> element.distance));
    pq.offer(new Element(source, 0));
    while (!pq.isEmpty()) {
      Element head = pq.poll();
      if (result[head.node] == Integer.MAX_VALUE) {
        result[head.node] = head.distance;

        for (int edge : edgeLists[head.node]) {
          int other = getOther(a, b, edge, head.node);
          if (result[other] == Integer.MAX_VALUE) {
            pq.offer(new Element(other, result[head.node] + t[edge]));
          }
        }
      }
    }

    return result;
  }

  static int getOther(int[] a, int[] b, int edge, int node) {
    return (node == a[edge] - 1) ? (b[edge] - 1) : (a[edge] - 1);
  }
}

class Element {
  int node;
  int distance;

  public Element(int node, int distance) {
    this.node = node;
    this.distance = distance;
  }
}
