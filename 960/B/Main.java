import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k1 = sc.nextInt();
    int k2 = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, k1, k2));

    sc.close();
  }

  static long solve(int[] a, int[] b, int k1, int k2) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < a.length; ++i) {
      pq.offer(Math.abs(a[i] - b[i]));
    }

    for (int i = 0; i < k1 + k2; ++i) {
      pq.offer(Math.abs(pq.poll() - 1));
    }

    return pq.stream().mapToLong(x -> (long) x * x).sum();
  }
}