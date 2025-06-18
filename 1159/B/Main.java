import java.util.Scanner;
import java.util.stream.IntStream;

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
    return IntStream.range(0, a.length)
        .flatMap(
            i ->
                IntStream.of(0, a.length - 1)
                    .map(j -> (i == j) ? Integer.MAX_VALUE : (a[i] / Math.abs(i - j))))
        .min()
        .getAsInt();
  }
}