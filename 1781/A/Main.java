import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int w = sc.nextInt();
      int d = sc.nextInt();
      int h = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int f = sc.nextInt();
      int g = sc.nextInt();

      System.out.println(solve(w, d, h, a, b, f, g));
    }

    sc.close();
  }

  static int solve(int w, int d, int h, int a, int b, int f, int g) {
    return IntStream.of(
                b + g + Math.abs(a - f),
                (d - b) + (d - g) + Math.abs(a - f),
                a + f + Math.abs(b - g),
                (w - a) + (w - f) + Math.abs(b - g))
            .min()
            .getAsInt()
        + h;
  }
}
