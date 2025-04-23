import java.util.Scanner;
import java.util.stream.IntStream;

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
    int flipCount =
        (int)
            IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) != ((i == 0) ? '0' : s.charAt(i - 1)))
                .count();

    int cost = s.length() + flipCount;
    if (containDouble(s, "01") || containDouble(s, "10")) {
      return cost - 2;
    }
    if (s.charAt(0) == '1' && s.indexOf('0') != -1) {
      return s.contains("01") ? (cost - 2) : (cost - 1);
    }

    return cost - ((flipCount >= 2) ? 1 : 0);
  }

  static boolean containDouble(String s, String target) {
    int index = s.indexOf(target);
    if (index == -1) {
      return false;
    }

    return s.indexOf(target, index + target.length()) != -1;
  }
}