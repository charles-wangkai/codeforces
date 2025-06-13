import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, long k) {
    int result = Arrays.stream(a).map(Integer::bitCount).sum();
    PriorityQueue<Long> pq = new PriorityQueue<>();
    for (int ai : a) {
      for (long power = 1; power <= k; power <<= 1) {
        if ((ai & power) == 0) {
          pq.offer(power);
        }
      }
    }

    while (!pq.isEmpty() && pq.peek() <= k) {
      k -= pq.poll();
      ++result;
    }

    return result;
  }
}