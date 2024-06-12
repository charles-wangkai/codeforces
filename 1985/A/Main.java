import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(String a, String b) {
    return String.format("%c%s %c%s", b.charAt(0), a.substring(1), a.charAt(0), b.substring(1));
  }
}