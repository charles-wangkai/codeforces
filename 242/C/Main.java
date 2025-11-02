import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x0 = sc.nextInt();
    int y0 = sc.nextInt();
    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int n = sc.nextInt();
    int[] r = new int[n];
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      r[i] = sc.nextInt();
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(x0, y0, x1, y1, r, a, b));

    sc.close();
  }

  static int solve(int x0, int y0, int x1, int y1, int[] r, int[] a, int[] b) {
    Set<Point> points =
        IntStream.range(0, r.length)
            .boxed()
            .flatMap(i -> IntStream.rangeClosed(a[i], b[i]).mapToObj(y -> new Point(r[i], y)))
            .collect(Collectors.toSet());

    Map<Point, Integer> pointToDistance = new HashMap<>();
    pointToDistance.put(new Point(x0, y0), 0);

    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(x0, y0));

    while (!queue.isEmpty()) {
      Point head = queue.poll();

      for (int dx = -1; dx <= 1; ++dx) {
        for (int dy = -1; dy <= 1; ++dy) {
          Point next = new Point(head.x() + dx, head.y() + dy);
          if (points.contains(next) && !pointToDistance.containsKey(next)) {
            pointToDistance.put(next, pointToDistance.get(head) + 1);
            queue.offer(next);
          }
        }
      }
    }

    return pointToDistance.getOrDefault(new Point(x1, y1), -1);
  }
}

record Point(int x, int y) {}
