import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    String[] fields = s.split("[.e]");
    String a = fields[0];
    String d = fields[1];
    int b = Integer.parseInt(fields[2]);

    d += "0".repeat(Math.max(0, b - d.length()));

    String left = a + d.substring(0, b);
    String right = d.substring(b);

    return (right.isEmpty() || right.equals("0")) ? left : "%s.%s".formatted(left, right);
  }
}