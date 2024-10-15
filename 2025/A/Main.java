import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t));
    }

    sc.close();
  }

  static int solve(String s, String t) {
    int result = 0;
    boolean diff = false;
    for (int i = 0; i < Math.max(s.length(), t.length()); ++i) {
      if (!diff && i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) {
        result += (i == 0) ? 2 : 1;
      } else {
        diff = true;
        result += (i >= s.length() || i >= t.length()) ? 1 : 2;
      }
    }

    return result;
  }
}