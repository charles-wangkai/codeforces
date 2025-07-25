import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_003;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(int n) {
    return IntStream.range(0, n - 1).reduce(1, (acc, x) -> multiplyMod(acc, 3));
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}