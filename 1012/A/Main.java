import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[2 * n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static long solve(int[] a) {
    int n = a.length / 2;

    Arrays.sort(a);

    return Math.min(
        (long) (a[n - 1] - a[0]) * (a[a.length - 1] - a[n]),
        IntStream.rangeClosed(1, n - 1)
            .mapToLong(i -> (long) (a[a.length - 1] - a[0]) * (a[i + n - 1] - a[i]))
            .min()
            .orElse(Long.MAX_VALUE));
  }
}