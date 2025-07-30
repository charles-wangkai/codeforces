import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] t = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      t[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(t, b, k));

    sc.close();
  }

  static long solve(int[] t, int[] b, int k) {
    int[] sortedIndices =
        IntStream.range(0, t.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> b[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    long result = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    long lengthSum = 0;
    for (int index : sortedIndices) {
      pq.offer(t[index]);
      lengthSum += t[index];

      if (pq.size() == k + 1) {
        lengthSum -= pq.poll();
      }

      result = Math.max(result, lengthSum * b[index]);
    }

    return result;
  }
}