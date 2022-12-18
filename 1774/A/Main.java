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
    StringBuilder result = new StringBuilder();
    boolean extra = s.charAt(0) == '1';
    for (int i = 1; i < s.length(); ++i) {
      if (s.charAt(i) == '0') {
        result.append("+");
      } else {
        result.append(extra ? "-" : "+");
        extra = !extra;
      }
    }

    return result.toString();
  }
}
