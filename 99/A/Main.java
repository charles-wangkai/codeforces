import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String value = sc.next();

    System.out.println(solve(value));

    sc.close();
  }

  static String solve(String value) {
    String[] parts = value.split("\\.");
    if (parts[0].endsWith("9")) {
      return "GOTO Vasilisa.";
    }

    return (parts[1].charAt(0) < '5')
        ? parts[0]
        : new BigInteger(parts[0]).add(BigInteger.ONE).toString();
  }
}