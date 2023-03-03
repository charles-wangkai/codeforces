import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] s = new int[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(s));
    }

    sc.close();
  }

  static long solve(int[] s) {
    long result = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int power : s) {
      if (power == 0) {
        if (!pq.isEmpty()) {
          result += pq.poll();
        }
      } else {
        pq.offer(power);
      }
    }

    return result;
  }
}
