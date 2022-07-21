import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      sc.nextInt();
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, String t) {
    return hasSameNum(s, t, 'a')
        && hasSameNum(s, t, 'b')
        && hasSameNum(s, t, 'c')
        && s.replace("b", "").equals(t.replace("b", ""))
        && checkRelativeOrder(s.replace("c", ""), t.replace("c", ""), 'a', 'b')
        && checkRelativeOrder(s.replace("a", ""), t.replace("a", ""), 'b', 'c');
  }

  static boolean hasSameNum(String s, String t, char target) {
    return s.chars().filter(c -> c == target).count() == t.chars().filter(c -> c == target).count();
  }

  static boolean checkRelativeOrder(String s1, String s2, char left, char right) {
    int delta = 0;
    for (int i = 0; i < s1.length(); ++i) {
      if (s1.charAt(i) == left && s2.charAt(i) == right) {
        ++delta;
      } else if (s1.charAt(i) == right && s2.charAt(i) == left) {
        --delta;

        if (delta == -1) {
          return false;
        }
      }
    }

    return true;
  }
}