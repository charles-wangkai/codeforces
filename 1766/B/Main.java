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
    Set<String> seen = new HashSet<>();
    for (int i = 2; i < s.length(); ++i) {
      if (seen.contains(s.substring(i - 1, i + 1))) {
        return true;
      }

      seen.add(s.substring(i - 2, i));
    }

    return false;
  }
}
