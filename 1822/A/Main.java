import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      int n = sc.nextInt();
      int t = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, t));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int t) {
    return IntStream.range(0, a.length)
        .filter(i -> i + a[i] <= t)
        .boxed()
        .max(Comparator.comparing(i -> b[i]))
        .map(i -> i + 1)
        .orElse(-1);
  }
}
