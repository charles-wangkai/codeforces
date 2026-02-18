import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(n, a, b));

    sc.close();
  }

  static String solve(int n, int[] a, int[] b) {
    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < a.length; ++i) {
      adjLists[a[i] - 1].add(b[i] - 1);
      adjLists[b[i] - 1].add(a[i] - 1);
    }

    int[] distances = new int[n];
    Arrays.fill(distances, -1);
    distances[0] = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(0);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      for (int adj : adjLists[head]) {
        if (distances[adj] == -1) {
          distances[adj] = distances[head] + 1;
          queue.offer(adj);
        }
      }
    }

    int[] sortedNodes =
        IntStream.range(0, n)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> distances[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    boolean[] wins = new boolean[n];
    for (int node : sortedNodes) {
      wins[node] =
          adjLists[node].stream()
              .anyMatch(adj -> distances[adj] == distances[node] + 1 && !wins[adj]);
    }

    return wins[0] ? "Vladimir" : "Nikolay";
  }
}