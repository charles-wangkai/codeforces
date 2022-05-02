import java.util.Scanner;

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
    if (s.length() % 2 == 0) {
      return compare(s, "");
    }

    return (s.charAt(0) <= s.charAt(s.length() - 1))
        ? compare(s.substring(1), String.valueOf(s.charAt(0)))
        : compare(s.substring(0, s.length() - 1), String.valueOf(s.charAt(s.length() - 1)));
  }

  static String compare(String alice, String bob) {
    int aliceScore = alice.chars().map(c -> c - 'a' + 1).sum();
    int bobScore = bob.chars().map(c -> c - 'a' + 1).sum();

    return (aliceScore > bobScore)
        ? String.format("Alice %d", aliceScore - bobScore)
        : String.format("Bob %d", bobScore - aliceScore);
  }
}