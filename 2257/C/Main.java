import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n - 1];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int[] a = new int[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(p, a));
    }

    sc.close();
  }

  static String solve(int[] p, int[] a) {
    int n = p.length + 1;
    int m = a.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[n];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < p.length; ++i) {
      childLists[p[i] - 1].add(i + 1);
    }

    boolean[] dams = new boolean[n];
    for (int ai : a) {
      dams[ai - 1] = true;
    }

    List<Integer> sorted = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(0);
    while (!queue.isEmpty()) {
      int head = queue.poll();

      if (dams[head]) {
        sorted.add(head);
      }

      for (int child : childLists[head]) {
        queue.offer(child);
      }
    }

    return "%d %s"
        .formatted(
            m - 1,
            IntStream.range(0, m - 1)
                .map(i -> sorted.get(sorted.size() - 1 - i) + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}