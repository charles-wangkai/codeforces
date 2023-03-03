import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(String a, String b) {
    if (a.charAt(0) == b.charAt(0)) {
      return String.format("YES\n%c*", a.charAt(0));
    }
    if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
      return String.format("YES\n*%c", a.charAt(a.length() - 1));
    }

    for (int i = 0; i < a.length() - 1; ++i) {
      if (b.contains(a.substring(i, i + 2))) {
        return String.format("YES\n*%s*", a.substring(i, i + 2));
      }
    }

    return "NO";
  }
}
