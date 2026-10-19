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

  static int solve(String s) {
    boolean canLonger = false;
    boolean canShorter = false;
    for (int i = 1; i < s.length() - 1; ++i) {
      if (s.charAt(i - 1) == s.charAt(i + 1)) {
        if (s.charAt(i) == s.charAt(i - 1)) {
          canLonger = true;
        } else {
          canShorter = true;
        }
      }
    }

    return 1 + (canLonger ? 1 : 0) + (canShorter ? 1 : 0);
  }
}
