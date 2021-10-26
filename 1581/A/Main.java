import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1000000007;

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
    return IntStream.rangeClosed(3, 2 * n).reduce(1, Main::multiplyMod);
  }

  static int multiplyMod(int x, int y) {
    return (int) ((long) x * y % MODULUS);
  }
}
