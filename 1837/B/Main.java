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

  static int solve(String s) {
    int result = 2;
    int length = 2;
    for (int i = 1; i < s.length(); ++i) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        ++length;
        result = Math.max(result, length);
      } else {
        length = 2;
      }
    }

    return result;
  }
}
