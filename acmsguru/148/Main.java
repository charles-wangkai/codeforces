import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] W = new int[N];
    int[] L = new int[N];
    int[] P = new int[N];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      W[i] = Integer.parseInt(st.nextToken());
      L[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(W, L, P));
  }

  static String solve(int[] W, int[] L, int[] P) {
    int minCost = computeMinCost(W, L, P);

    return computeIndicesForMinCost(W, L, P, minCost).stream()
        .map(i -> i + 1)
        .map(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static List<Integer> computeIndicesForMinCost(int[] W, int[] L, int[] P, int minCost) {
    int N = W.length;

    PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(Element::needed));
    int cost = 0;
    int sum = 0;
    for (int i = N - 1; ; --i) {
      pq.offer(new Element(sum + L[i], i));
      cost += P[i];

      sum += W[i];

      while (!pq.isEmpty() && pq.peek().needed() < sum) {
        cost -= P[pq.poll().index()];
      }

      if (cost == minCost) {
        return pq.stream().map(Element::index).toList();
      }
    }
  }

  static int computeMinCost(int[] W, int[] L, int[] P) {
    int N = W.length;

    int result = Integer.MAX_VALUE;
    PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(Element::needed));
    int cost = 0;
    int sum = 0;
    for (int i = N - 1; i >= 0; --i) {
      pq.offer(new Element(sum + L[i], i));
      cost += P[i];

      sum += W[i];

      while (!pq.isEmpty() && pq.peek().needed() < sum) {
        cost -= P[pq.poll().index()];
      }

      result = Math.min(result, cost);
    }

    return result;
  }
}

record Element(int needed, int index) {}
