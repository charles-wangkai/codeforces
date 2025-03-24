import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static int solve(int[] a, int k) {
    int[] sums = new int[k];
    for (int i = 0; i < a.length; ++i) {
      sums[i % k] += a[i];
    }

    return IntStream.range(0, sums.length)
            .boxed()
            .min(Comparator.<Integer, Integer>comparing(i -> sums[i]).thenComparing(i -> i))
            .get()
        + 1;
  }
}