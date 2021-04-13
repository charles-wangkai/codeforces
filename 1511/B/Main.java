import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static String solve(int a, int b, int c) {
    return String.format("%d %d", pow10(a - 1) + pow10(c - 1), pow10(b - 1));
  }

  static int pow10(int exponent) {
    return IntStream.range(0, exponent).reduce(1, (result, x) -> result * 10);
  }
}
