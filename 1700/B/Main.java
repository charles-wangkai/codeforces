import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    return new BigInteger(s.startsWith("9") ? "1".repeat(s.length() + 1) : "9".repeat(s.length()))
        .subtract(new BigInteger(s))
        .toString();
  }
}