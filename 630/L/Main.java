import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    return "%05d"
        .formatted(
            new BigInteger(
                    "%c%c%c%c%c"
                        .formatted(s.charAt(0), s.charAt(2), s.charAt(4), s.charAt(3), s.charAt(1)))
                .pow(5)
                .mod(BigInteger.valueOf(100000)));
  }
}