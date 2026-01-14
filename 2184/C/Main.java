import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static int solve(int n, int k) {
    Map<Integer, Integer> valueToDistance = new HashMap<>();
    valueToDistance.put(n, 0);

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(n);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      if (head == k) {
        return valueToDistance.get(head);
      }

      for (int next : new int[] {head / 2, head - head / 2}) {
        if (!valueToDistance.containsKey(next)) {
          valueToDistance.put(next, valueToDistance.get(head) + 1);
          queue.offer(next);
        }
      }
    }

    return -1;
  }
}