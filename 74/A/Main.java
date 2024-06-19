import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] handle = new String[n];
    int[] plus = new int[n];
    int[] minus = new int[n];
    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];
    int[] d = new int[n];
    int[] e = new int[n];
    for (int i = 0; i < n; ++i) {
      handle[i] = sc.next();
      plus[i] = sc.nextInt();
      minus[i] = sc.nextInt();
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
      e[i] = sc.nextInt();
    }

    System.out.println(solve(handle, plus, minus, a, b, c, d, e));

    sc.close();
  }

  static String solve(
      String[] handle, int[] plus, int[] minus, int[] a, int[] b, int[] c, int[] d, int[] e) {
    return handle[
        IntStream.range(0, handle.length)
            .boxed()
            .max(
                Comparator.comparing(
                    i -> 100 * plus[i] - 50 * minus[i] + a[i] + b[i] + c[i] + d[i] + e[i]))
            .get()];
  }
}