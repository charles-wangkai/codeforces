import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

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
    return multiplyMod(
        multiplyMod(n, n - 1), IntStream.rangeClosed(1, n).reduce(Main::multiplyMod).getAsInt());
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}
