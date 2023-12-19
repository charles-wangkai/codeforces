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
    for (int leftLength = 1; leftLength < s.length(); ++leftLength) {
      String a = s.substring(0, leftLength);
      String b = s.substring(leftLength);
      if (a.charAt(0) != '0' && b.charAt(0) != '0' && Integer.parseInt(a) < Integer.parseInt(b)) {
        return "%s %s".formatted(a, b);
      }
    }

    return "-1";
  }
}