import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static int solve(int[] b) {
    return IntStream.range(0, b.length - 1)
        .map(i -> b[i] / gcd(b[i], b[i + 1]))
        .reduce(Main::lcm)
        .getAsInt();
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }

  static int lcm(int x, int y) {
    return x / gcd(x, y) * y;
  }
}