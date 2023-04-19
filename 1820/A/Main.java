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

  static int solve(String s) {
    if (s.equals("^")) {
      return 1;
    }

    int result = (s.startsWith("^") ? 0 : 1) + ((s.endsWith("^")) ? 0 : 1);
    int underscoreLength = 0;
    for (int i = 0; i <= s.length(); ++i) {
      if (i != s.length() && s.charAt(i) == '_') {
        ++underscoreLength;
      } else {
        result += Math.max(0, underscoreLength - 1);

        underscoreLength = 0;
      }
    }

    return result;
  }
}
