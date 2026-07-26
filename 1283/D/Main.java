import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(x, m));

    sc.close();
  }

  static String solve(int[] x, int m) {
    PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(Element::distance));
    for (int xi : x) {
      pq.offer(new Element(1, xi - 1, xi));
      pq.offer(new Element(1, xi + 1, xi));
    }

    Set<Integer> seen = new HashSet<>();
    for (int xi : x) {
      seen.add(xi);
    }

    long distanceSum = 0;
    List<Integer> y = new ArrayList<>();
    while (y.size() != m) {
      Element head = pq.poll();

      if (!seen.contains(head.position())) {
        distanceSum += head.distance();
        y.add(head.position());
        seen.add(head.position());

        pq.offer(
            new Element(head.distance() + 1, head.from() - (head.distance() + 1), head.from()));
        pq.offer(
            new Element(head.distance() + 1, head.from() + (head.distance() + 1), head.from()));
      }
    }

    return "%d\n%s"
        .formatted(distanceSum, y.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}

record Element(int distance, int position, int from) {}
