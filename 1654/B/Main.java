import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

  static String solve(String s) {
    int beginIndex = -1;
    Set<Character> seen = new HashSet<>();
    for (int i = s.length() - 1; i >= 0; --i) {
      char c = s.charAt(i);
      if (!seen.contains(c)) {
        beginIndex = i;
        seen.add(c);
      }
    }

    return s.substring(beginIndex);
  }
}