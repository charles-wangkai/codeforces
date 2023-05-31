import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, x) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] a, int x) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int ai : a) {
      if (ai != x) {
        pq.offer(ai);
      }
    }

    int current = -1;
    int count = 0;
    while (!pq.isEmpty()) {
      int head = pq.poll();
      if (count == 0) {
        current = head;
        ++count;
      } else if (head == current) {
        ++count;
      } else {
        return false;
      }

      if (count == head + 1) {
        if (current + 1 != x) {
          pq.offer(current + 1);
        }

        count = 0;
      }
    }

    return count == 0;
  }
}
