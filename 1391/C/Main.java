import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(int n) {
    return subtractMod(
        IntStream.rangeClosed(1, n).reduce(Main::multiplyMod).getAsInt(),
        IntStream.range(0, n - 1).reduce(1, (res, i) -> multiplyMod(res, 2)));
  }

  static int subtractMod(int x, int y) {
    return (x - y + MODULUS) % MODULUS;
  }

  static int multiplyMod(int x, int y) {
    return (int) ((long) x * y % MODULUS);
  }
}
