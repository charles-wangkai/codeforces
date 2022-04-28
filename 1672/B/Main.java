import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s2 = sc.next();

      System.out.println(solve(s2) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s2) {
    if (s2.charAt(s2.length() - 1) == 'A') {
      return false;
    }

    int delta = 0;
    for (char c : s2.toCharArray()) {
      if (c == 'A') {
        ++delta;
      } else {
        if (delta == 0) {
          return false;
        }
        --delta;
      }
    }

    return true;
  }
}