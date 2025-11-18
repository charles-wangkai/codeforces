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
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    Arrays.sort(a);

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int bi : b) {
      pq.offer(bi);
    }

    int rest = a.length - b.length;
    for (int i = a.length - 1; i >= 0; --i) {
      while (true) {
        if (pq.isEmpty()) {
          return false;
        }

        int head = pq.poll();
        if (head < a[i]) {
          return false;
        }
        if (head == a[i]) {
          break;
        }
        if (rest == 0) {
          return false;
        }

        pq.offer(head / 2);
        pq.offer(head - head / 2);
        --rest;
      }
    }

    return true;
  }
}