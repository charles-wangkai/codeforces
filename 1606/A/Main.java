import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    return (s.charAt(0) == s.charAt(s.length() - 1))
        ? s
        : String.format("a%sa", s.substring(1, s.length() - 1));
  }
}
