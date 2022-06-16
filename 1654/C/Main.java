import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int[] sorted =
        Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();
    int index = 0;

    PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
    pq.offer(Arrays.stream(a).asLongStream().sum());

    while (!pq.isEmpty()) {
      long head = pq.poll();
      if (head < sorted[index]) {
        return false;
      }

      if (head == sorted[index]) {
        ++index;
      } else {
        pq.offer(head / 2);
        pq.offer(head - head / 2);
      }
    }

    return true;
  }
}