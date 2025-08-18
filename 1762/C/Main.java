import java.util.Scanner;

public class Main {
  static final int MODULUS = 998_244_353;

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
    int result = 0;
    int wayNum = -1;
    for (int i = 0; i < s.length(); ++i) {
      if (i != 0 && s.charAt(i) == s.charAt(i - 1)) {
        wayNum = multiplyMod(wayNum, 2);
      } else {
        wayNum = 1;
      }

      result = addMod(result, wayNum);
    }

    return result;
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}