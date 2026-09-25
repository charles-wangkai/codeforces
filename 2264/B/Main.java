import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static long solve(int[] a, int m) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    long sum = 0;
    for (int i = 0; i < m - 1; ++i) {
      pq.offer(a[i]);
      sum += a[i];
    }

    long result = Long.MIN_VALUE;
    for (int i = m - 1; i < a.length; ++i) {
      result = Math.max(result, (long) m * a[i] - sum);

      pq.offer(a[i]);
      sum += a[i];

      if (pq.size() == m) {
        sum -= pq.poll();
      }
    }

    return result;
  }
}