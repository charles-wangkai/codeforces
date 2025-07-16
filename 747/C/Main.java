import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] t = new int[q];
    int[] k = new int[q];
    int[] d = new int[q];
    for (int i = 0; i < q; ++i) {
      t[i] = sc.nextInt();
      k[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(n, t, k, d));

    sc.close();
  }

  static String solve(int n, int[] t, int[] k, int[] d) {
    int[] result = new int[t.length];
    PriorityQueue<Integer> freeServerIds = new PriorityQueue<>();
    for (int i = 1; i <= n; ++i) {
      freeServerIds.offer(i);
    }
    PriorityQueue<Event> events = new PriorityQueue<>(Comparator.comparing(Event::freeTime));
    for (int i = 0; i < result.length; ++i) {
      while (!events.isEmpty() && events.peek().freeTime() <= t[i]) {
        freeServerIds.offer(events.poll().serverId());
      }

      if (freeServerIds.size() >= k[i]) {
        for (int j = 0; j < k[i]; ++j) {
          int serverId = freeServerIds.poll();
          events.offer(new Event(serverId, t[i] + d[i]));
          result[i] += serverId;
        }

      } else {
        result[i] = -1;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}

record Event(int serverId, int freeTime) {}
