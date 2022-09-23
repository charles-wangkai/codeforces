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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    PriorityQueue<Integer> aRest = new PriorityQueue<>(Comparator.reverseOrder());
    for (int ai : a) {
      aRest.offer(ai);
    }

    PriorityQueue<Integer> bRest = new PriorityQueue<>(Comparator.reverseOrder());
    for (int bi : b) {
      bRest.offer(bi);
    }

    int result = 0;
    while (!aRest.isEmpty()) {
      int aHead = aRest.peek();
      int bHead = bRest.peek();

      if (aHead > bHead) {
        aRest.offer(String.valueOf(aRest.poll()).length());
        ++result;
      } else if (aHead < bHead) {
        bRest.offer(String.valueOf(bRest.poll()).length());
        ++result;
      } else {
        aRest.poll();
        bRest.poll();
      }
    }

    return result;
  }
}