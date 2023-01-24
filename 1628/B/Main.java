import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String[] s = new String[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.next();
      }

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String[] s) {
    if (Arrays.stream(s).anyMatch(x -> new StringBuilder(x).reverse().toString().equals(x))) {
      return true;
    }

    Set<String> leftSeen = new HashSet<>();
    for (String si : s) {
      if (leftSeen.contains(new StringBuilder(si).reverse().toString())
          || leftSeen.contains(new StringBuilder(si.substring(1)).reverse().toString())) {
        return true;
      }

      leftSeen.add(si);
    }

    Set<String> rightSeen = new HashSet<>();
    for (int i = s.length - 1; i >= 0; --i) {
      if (rightSeen.contains(
          new StringBuilder(s[i].substring(0, s[i].length() - 1)).reverse().toString())) {
        return true;
      }

      rightSeen.add(s[i]);
    }

    return false;
  }
}
