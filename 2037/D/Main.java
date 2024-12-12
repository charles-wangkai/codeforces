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
      int L = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }
      int[] x = new int[m];
      int[] v = new int[m];
      for (int i = 0; i < m; ++i) {
        x[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(l, r, x, v, L));
    }

    sc.close();
  }

  static int solve(int[] l, int[] r, int[] x, int[] v, int L) {
    int result = 0;
    int power = 1;
    PriorityQueue<Integer> ups = new PriorityQueue<>(Comparator.reverseOrder());
    int upIndex = 0;
    for (int i = 0; i < l.length; ++i) {
      while (upIndex != x.length && x[upIndex] < l[i]) {
        ups.offer(v[upIndex]);
        ++upIndex;
      }

      while (power < r[i] - l[i] + 2) {
        if (ups.isEmpty()) {
          return -1;
        }

        power += ups.poll();
        ++result;
      }
    }

    return result;
  }
}