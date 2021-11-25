import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    return String.format("3\nL 2\nR 2\nR %d", s.length() * 2 - 1);
  }
}
