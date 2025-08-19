import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(queries));

    sc.close();
  }

  static String solve(String[] queries) {
    List<Integer> result = new ArrayList<>();
    List<Integer> moneys = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();
    PriorityQueue<Integer> pq =
        new PriorityQueue<>(
            Comparator.comparing(moneys::get)
                .reversed()
                .thenComparing(Comparator.comparing(i -> i)));
    Set<Integer> seen = new HashSet<>();
    for (String query : queries) {
      String[] fields = query.split(" ");
      if (fields[0].equals("1")) {
        int m = Integer.parseInt(fields[1]);

        moneys.add(m);
        queue.offer(moneys.size() - 1);
        pq.offer(moneys.size() - 1);
      } else {
        Queue<Integer> q = fields[0].equals("2") ? queue : pq;
        while (seen.contains(q.peek())) {
          q.poll();
        }

        int index = q.poll();
        result.add(index + 1);
        seen.add(index);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}