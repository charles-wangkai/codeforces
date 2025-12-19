import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[n];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(queries));

    sc.close();
  }

  static String solve(String[] queries) {
    List<String> result = new ArrayList<>();
    List<Interval> intervals = new ArrayList<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        intervals.add(new Interval(fields[1], fields[2]));
      } else {
        result.add(canReach(intervals, fields[1] - 1, fields[2] - 1) ? "YES" : "NO");
      }
    }

    return String.join("\n", result);
  }

  static boolean canReach(List<Interval> intervals, int from, int to) {
    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[intervals.size()];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < intervals.size(); ++i) {
      for (int j = 0; j < intervals.size(); ++j) {
        if ((intervals.get(j).begin() < intervals.get(i).begin()
                && intervals.get(j).end() > intervals.get(i).begin())
            || (intervals.get(j).begin() < intervals.get(i).end()
                && intervals.get(j).end() > intervals.get(i).end())) {
          adjLists[i].add(j);
        }
      }
    }

    boolean[] visited = new boolean[intervals.size()];
    visited[from] = true;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(from);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      if (head == to) {
        return true;
      }

      for (int adj : adjLists[head]) {
        if (!visited[adj]) {
          visited[adj] = true;
          queue.offer(adj);
        }
      }
    }

    return false;
  }
}

record Interval(int begin, int end) {}
