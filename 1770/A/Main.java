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
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int ai : a) {
      pq.offer(ai);
    }

    for (int bi : b) {
      pq.poll();
      pq.offer(bi);
    }

    return pq.stream().mapToInt(x -> x).asLongStream().sum();
  }
}
