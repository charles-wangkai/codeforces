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
    if (s.chars().filter(ch -> ch == 'M').count() * 3 != s.length()) {
      return false;
    }

    int depth = 0;
    for (char ch : s.toCharArray()) {
      if (ch == 'T') {
        ++depth;
      } else {
        --depth;
        if (depth == -1) {
          return false;
        }
      }
    }

    depth = 0;
    for (int i = s.length() - 1; i >= 0; --i) {
      if (s.charAt(i) == 'T') {
        ++depth;
      } else {
        --depth;
        if (depth == -1) {
          return false;
        }
      }
    }

    return true;
  }
}
