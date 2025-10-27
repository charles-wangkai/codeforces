import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    int[] q = new int[m];
    for (int i = 0; i < q.length; ++i) {
      q[i] = sc.nextInt();
    }
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(q, a));

    sc.close();
  }

  static int solve(int[] q, int[] a) {
    int minQ = Arrays.stream(q).min().getAsInt();

    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    return IntStream.range(0, sorted.length)
        .filter(i -> i % (minQ + 2) < minQ)
        .map(i -> sorted[i])
        .sum();
  }
}