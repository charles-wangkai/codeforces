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

  static int solve(String s) {
    int result = 0;
    int index = 0;
    while (index != s.length()) {
      ++result;
      Set<Character> seen = new HashSet<>();
      while (index != s.length() && (seen.size() <= 2 || seen.contains(s.charAt(index)))) {
        seen.add(s.charAt(index));
        ++index;
      }
    }

    return result;
  }
}