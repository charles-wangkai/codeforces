import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t));
    }

    sc.close();
  }

  static String solve(String s, String t) {
    int length =
        s.length()
            * t.length()
            / BigInteger.valueOf(s.length()).gcd(BigInteger.valueOf(t.length())).intValue();
    String extendedS = s.repeat(length / s.length());
    String extendedT = t.repeat(length / t.length());

    return extendedS.equals(extendedT) ? extendedS : "-1";
  }
}
