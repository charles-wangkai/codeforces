import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(h, p, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] h, int[] p, int k) {
    SortedMap<Integer, Integer> powerToCount = new TreeMap<>();
    for (int pi : p) {
      updateMap(powerToCount, pi, 1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> h[i]));
    for (int i = 0; i < h.length; ++i) {
      pq.offer(i);
    }

    int damaged = 0;
    while (!pq.isEmpty()) {
      if (k <= 0) {
        return false;
      }
      damaged += k;

      while (!pq.isEmpty() && h[pq.peek()] <= damaged) {
        updateMap(powerToCount, p[pq.poll()], -1);
      }

      if (!powerToCount.isEmpty()) {
        k -= powerToCount.firstKey();
      }
    }

    return true;
  }

  static void updateMap(SortedMap<Integer, Integer> powerToCount, int power, int delta) {
    powerToCount.put(power, powerToCount.getOrDefault(power, 0) + delta);
    powerToCount.remove(power, 0);
  }
}
