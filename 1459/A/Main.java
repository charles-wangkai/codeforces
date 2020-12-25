import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      sc.nextInt();
      String r = sc.next();
      String b = sc.next();

      System.out.println(solve(r, b));
    }

    sc.close();
  }

  static String solve(String r, String b) {
    int rWin = 0;
    int bWin = 0;
    for (int i = 0; i < r.length(); ++i) {
      if (r.charAt(i) > b.charAt(i)) {
        ++rWin;
      } else if (r.charAt(i) < b.charAt(i)) {
        ++bWin;
      }
    }

    if (rWin > bWin) {
      return "RED";
    } else if (rWin < bWin) {
      return "BLUE";
    } else {
      return "EQUAL";
    }
  }
}
