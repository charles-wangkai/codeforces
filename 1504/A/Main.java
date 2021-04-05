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
    if (!isPalindrome('a' + s)) {
      return String.format("YES\n%s", 'a' + s);
    }
    if (!isPalindrome(s + 'a')) {
      return String.format("YES\n%s", s + 'a');
    }

    return "NO";
  }

  static boolean isPalindrome(String str) {
    return new StringBuilder(str).reverse().toString().equals(str);
  }
}
