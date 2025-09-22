import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    return IntStream.range(0, a.length)
        .mapToLong(
            i ->
                IntStream.range(0, a.length)
                    .filter(j -> j != i)
                    .boxed()
                    .flatMapToLong(
                        j -> IntStream.range(0, b.length).mapToLong(k -> (long) a[j] * b[k]))
                    .max()
                    .getAsLong())
        .min()
        .getAsLong();
  }
}