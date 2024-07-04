import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    int result = 1;
    Set<Character> seen = new HashSet<>();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c == '?') {
        result *= (i == 0) ? 9 : 10;
      } else if (!Character.isDigit(c) && !seen.contains(c)) {
        result *= (i == 0) ? 9 : (10 - seen.size());
        seen.add(c);
      }
    }

    return result;
  }
}