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

  static String solve(String s) {
    int productPrefix = 1;
    int trailingZeroNum = 0;
    Set<Character> seen = new HashSet<>();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c == '?') {
        productPrefix *= (i == 0) ? 9 : 10;
      } else if (!Character.isDigit(c) && !seen.contains(c)) {
        productPrefix *= (i == 0) ? 9 : (10 - seen.size());
        seen.add(c);
      }

      while (productPrefix % 10 == 0) {
        productPrefix /= 10;
        ++trailingZeroNum;
      }
    }

    return "%d%s".formatted(productPrefix, "0".repeat(trailingZeroNum));
  }
}