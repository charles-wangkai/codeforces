import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    return (int) IntStream.range(0, 15).filter(Main::isFizzBuzz).count() * ((n + 1) / 15)
        + (int) IntStream.rangeClosed((n + 1) / 15 * 15, n).filter(Main::isFizzBuzz).count();
  }

  static boolean isFizzBuzz(int x) {
    return x % 3 == x % 5;
  }
}