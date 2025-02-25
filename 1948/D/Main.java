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
    for (int halfLength = s.length() / 2; halfLength >= 1; --halfLength) {
      if (check(s, halfLength)) {
        return halfLength * 2;
      }
    }

    return 0;
  }

  static boolean check(String s, int halfLength) {
    int count = 0;
    for (int i = halfLength; i < s.length(); ++i) {
      if (isMatch(s.charAt(i - halfLength), s.charAt(i))) {
        ++count;
        if (count == halfLength) {
          return true;
        }
      } else {
        count = 0;
      }
    }

    return false;
  }

  static boolean isMatch(char c1, char c2) {
    return c1 == '?' || c2 == '?' || c1 == c2;
  }
}