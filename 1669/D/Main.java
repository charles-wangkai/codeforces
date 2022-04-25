import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    int rCount = 0;
    int bCount = 0;
    for (int i = 0; i <= s.length(); ++i) {
      if (i == s.length() || s.charAt(i) == 'W') {
        if ((rCount == 0) != (bCount == 0)) {
          return false;
        }

        rCount = 0;
        bCount = 0;
      } else if (s.charAt(i) == 'R') {
        ++rCount;
      } else {
        ++bCount;
      }
    }

    return true;
  }
}