import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] u = new int[m];
      int[] v = new int[m];
      int[] w = new int[m];
      for (int i = 0; i < m; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
        w[i] = sc.nextInt();
      }
      int[] s = new int[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(s, u, v, w));
    }

    sc.close();
  }

  static long solve(int[] s, int[] u, int[] v, int[] w) {
    int n = s.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[u[i] - 1].add(i);
      edgeLists[v[i] - 1].add(i);
    }

    Map<State, Long> stateToTime = new HashMap<>();

    PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(Element::time));
    pq.offer(new Element(new State(0, s[0]), 0));

    while (!pq.isEmpty()) {
      Element head = pq.poll();
      if (!stateToTime.containsKey(head.state())) {
        stateToTime.put(head.state(), head.time());

        for (int edge : edgeLists[head.state().node()]) {
          int nextNode = (u[edge] - 1 == head.state().node()) ? (v[edge] - 1) : (u[edge] - 1);
          int nextMinSlowness = Math.min(head.state().minSlowness(), s[nextNode]);
          State nextState = new State(nextNode, nextMinSlowness);
          if (!stateToTime.containsKey(nextState)) {
            pq.offer(new Element(nextState, head.time() + w[edge] * head.state().minSlowness()));
          }
        }
      }
    }

    return stateToTime.keySet().stream()
        .filter(state -> state.node() == n - 1)
        .mapToLong(stateToTime::get)
        .min()
        .getAsLong();
  }
}

record State(int node, int minSlowness) {}

record Element(State state, long time) {}
