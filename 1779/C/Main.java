import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

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

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static int solve(int[] a, int m) {
    return computeOperationNum(IntStream.range(1, m).map(i -> -a[m - i]).toArray())
        + computeOperationNum(IntStream.range(m, a.length).map(i -> a[i]).toArray());
  }

  static int computeOperationNum(int[] values) {
    int result = 0;
    long sum = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int value : values) {
      sum += value;
      if (value < 0) {
        pq.offer(value);
      }

      while (sum < 0) {
        sum += -pq.poll() * 2;
        ++result;
      }
    }

    return result;
  }
}
