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

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    @SuppressWarnings("unchecked")
    PriorityQueue<Integer>[] pqs = new PriorityQueue[2];
    for (int i = 0; i < pqs.length; ++i) {
      pqs[i] = new PriorityQueue<>(Comparator.reverseOrder());
    }
    for (int ai : a) {
      pqs[0].offer(ai);
    }
    for (int bi : b) {
      pqs[1].offer(bi);
    }

    int current = 0;
    while (true) {
      int other = 1 - current;

      int otherRest = pqs[other].poll() - pqs[current].peek();
      if (otherRest > 0) {
        pqs[other].offer(otherRest);
      }
      if (pqs[other].isEmpty()) {
        return (current == 0) ? "Alice" : "Bob";
      }

      current = 1 - current;
    }
  }
}