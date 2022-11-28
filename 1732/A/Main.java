import java.util.Arrays;
import java.util.Scanner;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int g = Arrays.stream(a).reduce(Main::gcd).getAsInt();

    return (g == 1)
        ? 0
        : Math.min(
            3,
            IntStream.range(0, a.length)
                .filter(i -> gcd(g, i + 1) == 1)
                .map(i -> a.length - i)
                .min()
                .getAsInt());
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
