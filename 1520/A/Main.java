import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
    Set<Character> solved = new HashSet<>();
    char prev = 0;
    for (char ch : s.toCharArray()) {
      if (ch != prev && solved.contains(ch)) {
        return false;
      }

      solved.add(ch);
      prev = ch;
    }

    return true;
  }
}
