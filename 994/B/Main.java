import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }
    int[] c = new int[n];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }

    System.out.println(solve(p, c, k));

    sc.close();
  }

  static String solve(int[] p, int[] c, int k) {
    long[] result = new long[p.length];
    PriorityQueue<Integer> coins = new PriorityQueue<>();
    long coinSum = 0;
    int[] sortedIndices =
        IntStream.range(0, p.length)
            .boxed()
            .sorted(Comparator.comparing(i -> p[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    for (int index : sortedIndices) {
      result[index] = c[index] + coinSum;

      coins.offer(c[index]);
      coinSum += c[index];

      if (coins.size() == k + 1) {
        coinSum -= coins.poll();
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}