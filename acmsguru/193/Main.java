import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    BigInteger N = sc.nextBigInteger();
    System.out.println(solve(N));

    sc.close();
  }

  static BigInteger solve(BigInteger N) {
    BigInteger K = N.divide(BigInteger.TWO);
    while (!N.gcd(K).equals(BigInteger.ONE)) {
      K = K.subtract(BigInteger.ONE);
    }

    return K;
  }
}