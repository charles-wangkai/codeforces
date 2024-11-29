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
    for (int i = 0; i < s.length() - 1; ++i) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        return s.substring(i, i + 2);
      }
    }

    for (int i = 0; i < s.length() - 2; ++i) {
      if (s.charAt(i) != s.charAt(i + 2)) {
        return s.substring(i, i + 3);
      }
    }

    return "-1";
  }
}