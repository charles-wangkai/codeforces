import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();
      sc.nextInt();
      String l = sc.next();
      String r = sc.next();

      System.out.println(solve(s, l, r) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, String l, String r) {
    int index = 0;
    Set<Character> seen = new HashSet<>();
    for (char c : s.toCharArray()) {
      if (c >= l.charAt(index) && c <= r.charAt(index)) {
        seen.add(c);

        if (seen.size() == r.charAt(index) - l.charAt(index) + 1) {
          seen.clear();
          ++index;
          if (index == l.length()) {
            return false;
          }
        }
      }
    }

    return true;
  }
}
