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
    int[] extras = new int[2];
    int count = 0;
    for (int i = 0; i <= s.length(); ++i) {
      if (i != 0 && i != s.length() && s.charAt(i) == s.charAt(i - 1)) {
        ++count;
      } else {
        if (count != 0) {
          extras[s.charAt(i - 1) - '0'] += count - 1;
        }

        count = 1;
      }
    }

    if (Math.abs(extras[0] - extras[1]) <= 1) {
      return extras[0] + extras[1];
    }
    if (extras[0] - extras[1] == 2 && (s.startsWith("1") || s.endsWith("1"))) {
      return extras[0] + extras[1] + 1;
    }
    if (extras[0] - extras[1] == 3 && s.startsWith("1") && s.endsWith("1")) {
      return extras[0] + extras[1] + 2;
    }
    if (extras[1] - extras[0] == 2 && (s.startsWith("0") || s.endsWith("0"))) {
      return extras[0] + extras[1] + 1;
    }
    if (extras[1] - extras[0] == 3 && s.startsWith("0") && s.endsWith("0")) {
      return extras[0] + extras[1] + 2;
    }

    return -1;
  }
}