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
      int[] a = new int[2 * n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int n = a.length / 2;

    Arrays.sort(a);

    return String.format(
        "%d\n%s",
        (a[n - 1] - a[0]) + (a[2 * n - 1] - a[n]),
        IntStream.range(0, n)
            .mapToObj(i -> String.format("%d %d", a[i], a[i + n]))
            .collect(Collectors.joining("\n")));
  }
}
