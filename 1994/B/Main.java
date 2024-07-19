import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      sc.nextInt();
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(String s, String t) {
    for (int i = 0; i < s.length() && s.charAt(i) == '0'; ++i) {
      if (t.charAt(i) == '1') {
        return false;
      }
    }

    return true;
  }
}