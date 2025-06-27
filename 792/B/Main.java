import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[k];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(n, a));

    sc.close();
  }

  static String solve(int n, int[] a) {
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; ++i) {
      queue.offer(i);
    }

    List<Integer> result = new ArrayList<>();
    for (int ai : a) {
      for (int i = 0; i < ai % queue.size(); ++i) {
        queue.offer(queue.poll());
      }

      result.add(queue.poll());
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}