import java.math.BigInteger;
import java.util.Scanner;

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
    return BigInteger.valueOf(n)
        .multiply(BigInteger.valueOf(n + 1))
        .multiply(BigInteger.valueOf(2 * n + 1))
        .divide(BigInteger.valueOf(6))
        .add(
            BigInteger.valueOf(n - 1)
                .multiply(BigInteger.valueOf(n))
                .multiply(BigInteger.valueOf(n + 1))
                .divide(BigInteger.valueOf(3)))
        .multiply(BigInteger.valueOf(2022))
        .mod(BigInteger.valueOf(MODULUS))
        .intValue();
  }
}
