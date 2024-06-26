import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int d = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m, d));
    }

    sc.close();
  }

  static long solve(int[] a, int m, int d) {
    long result = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    long sum = 0;
    for (int i = 0; i < a.length; ++i) {
      if (a[i] > 0) {
        pq.offer(a[i]);
        sum += a[i];

        if (pq.size() == m + 1) {
          sum -= pq.poll();
        }
      }

      result = Math.max(result, sum - d * (i + 1L));
    }

    return result;
  }
}