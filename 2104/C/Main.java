import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    if (s.endsWith("A")) {
      return (s.startsWith("A") || s.charAt(s.length() - 2) == 'A') ? "Alice" : "Bob";
    }

    return (s.chars().filter(c -> c == 'B').count() == 1) ? "Alice" : "Bob";
  }
}