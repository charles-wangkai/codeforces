import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String n = sc.next();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(String n) {
    BigInteger value = new BigInteger(n);
    if (value.compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0
        && value.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0) {
      return "byte";
    }
    if (value.compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0
        && value.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0) {
      return "short";
    }
    if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0
        && value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
      return "int";
    }
    if (value.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0
        && value.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
      return "long";
    }

    return "BigInteger";
  }
}