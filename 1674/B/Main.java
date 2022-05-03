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
    int result = 0;
    for (char c1 = 'a'; ; ++c1) {
      for (char c2 = 'a'; c2 <= 'z'; ++c2) {
        if (c2 != c1) {
          ++result;

          if (c1 == s.charAt(0) && c2 == s.charAt(1)) {
            return result;
          }
        }
      }
    }
  }
}