import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] c) {
    int n = a.length;

    int[] p = new int[n];
    p[0] = a[0];
    for (int i = 1; i < n - 1; ++i) {
      int i_ = i;
      p[i] = IntStream.of(a[i], b[i]).filter(x -> x != p[i_ - 1]).findAny().getAsInt();
    }
    p[n - 1] =
        IntStream.of(a[n - 1], b[n - 1], c[n - 1])
            .filter(x -> x != p[n - 2] && x != p[0])
            .findAny()
            .getAsInt();

    return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
