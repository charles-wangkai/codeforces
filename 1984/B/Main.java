import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long x = sc.nextLong();

      System.out.println(solve(x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(long x) {
    String s = String.valueOf(x);
    if (s.charAt(0) != '1') {
      return false;
    }

    for (int i = 1; i < s.length(); ++i) {
      int value = 10 + (s.charAt(i) - '0');
      if (!(value >= 10 + ((i == s.length() - 1) ? 0 : 1)
          && value <= 18 + ((i == s.length() - 1) ? 0 : 1))) {
        return false;
      }
    }

    return true;
  }
}