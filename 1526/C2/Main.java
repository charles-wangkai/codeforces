import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    long sum = 0;
    int nonNegCount = 0;
    PriorityQueue<Integer> negs = new PriorityQueue<>();
    for (int ai : a) {
      if (ai >= 0) {
        sum += ai;
        ++nonNegCount;
      } else if (sum + ai >= 0) {
        sum += ai;
        negs.offer(ai);
      } else if (!negs.isEmpty() && ai > negs.peek()) {
        sum += ai - negs.peek();
        negs.poll();
        negs.offer(ai);
      }
    }

    return nonNegCount + negs.size();
  }
}
