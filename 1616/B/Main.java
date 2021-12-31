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
    int endIndex = 0;
    while (endIndex + 1 != s.length() && s.charAt(endIndex + 1) <= s.charAt(endIndex)) {
      ++endIndex;
    }

    return min(
        String.format(
            "%s%s",
            s.substring(0, endIndex + 1),
            new StringBuilder(s.substring(0, endIndex + 1)).reverse().toString()),
        String.format("%c%c", s.charAt(0), s.charAt(0)));
  }

  static String min(String s1, String s2) {
    return (s1.compareTo(s2) <= 0) ? s1 : s2;
  }
}
