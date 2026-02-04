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
    int result = (int) s.chars().filter(c -> c == '1').count();
    int count = 0;
    for (int i = 0; i <= s.length(); ++i) {
      if (i != s.length() && s.charAt(i) == '0') {
        ++count;
      } else {
        int free = count - ((i == count) ? 0 : 1) - ((i == s.length()) ? 0 : 1);
        if (free > 0) {
          result += Math.ceilDiv(free, 3);
        }

        count = 0;
      }
    }

    return result;
  }
}