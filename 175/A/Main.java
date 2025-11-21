import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    int result = -1;
    for (int length1 = 1; length1 < s.length(); ++length1) {
      for (int length2 = 1; length1 + length2 < s.length(); ++length2) {
        String s1 = s.substring(0, length1);
        String s2 = s.substring(length1, length1 + length2);
        String s3 = s.substring(length1 + length2);
        if (isValidPoint(s1) && isValidPoint(s2) && isValidPoint(s3)) {
          result =
              Math.max(result, Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3));
        }
      }
    }

    return result;
  }

  static boolean isValidPoint(String str) {
    BigInteger value = new BigInteger(str);

    return value.toString().equals(str) && value.compareTo(BigInteger.valueOf(1_000_000)) <= 0;
  }
}