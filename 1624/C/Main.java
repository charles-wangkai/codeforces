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
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int ai : a) {
      pq.offer(ai);
    }

    for (int i = a.length; i >= 1; --i) {
      while (true) {
        int head = pq.poll();
        if (head < i) {
          return false;
        }
        if (head == i) {
          break;
        }

        pq.offer(head / 2);
      }
    }

    return true;
  }
}
