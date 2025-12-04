import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String a = sc.next();
    String b = sc.next();

    System.out.println(solve(a, b) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String a, String b) {
    return a.length() == b.length() && (a.equals(b) || (a.contains("1") && b.contains("1")));
  }
}