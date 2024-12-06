import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      String[] s = new String[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.next();
      }

      System.out.println(solve(s, m));
    }

    sc.close();
  }

  static int solve(String[] s, int m) {
    int result = 0;
    for (String si : s) {
      if (si.length() > m) {
        break;
      }

      m -= si.length();
      ++result;
    }

    return result;
  }
}