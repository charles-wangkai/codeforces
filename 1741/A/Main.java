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
    int aValue = toValue(a);
    int bValue = toValue(b);

    if (aValue < bValue) {
      return "<";
    }
    if (aValue > bValue) {
      return ">";
    }

    return "=";
  }

  static int toValue(String size) {
    if (size.equals("M")) {
      return 0;
    }

    return ((size.charAt(size.length() - 1) == 'L') ? 1 : -1) * size.length();
  }
}
