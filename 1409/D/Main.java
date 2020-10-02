import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();
      int s = sc.nextInt();

      System.out.println(solve(n, s));
    }

    sc.close();
  }

  static BigInteger solve(long n, int s) {
    BigInteger placeValue = BigInteger.ONE;
    BigInteger current = BigInteger.valueOf(n);
    while (computeDigitSum(current) > s) {
      current = current.divide(placeValue).multiply(placeValue).add(placeValue);
      placeValue = placeValue.multiply(BigInteger.TEN);
    }

    return current.subtract(BigInteger.valueOf(n));
  }

  static int computeDigitSum(BigInteger x) {
    return x.toString().chars().map(ch -> ch - '0').sum();
  }
}
