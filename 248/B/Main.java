import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final int FACTOR = 2 * 3 * 5 * 7;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    if (n <= 2) {
      return "-1";
    }

    return new BigInteger("1" + "0".repeat(n - 1))
        .add(BigInteger.valueOf(FACTOR - 1))
        .divide(BigInteger.valueOf(FACTOR))
        .multiply(BigInteger.valueOf(FACTOR))
        .toString();
  }
}