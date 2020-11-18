import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int c0 = sc.nextInt();
      int c1 = sc.nextInt();
      int h = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, c0, c1, h));
    }

    sc.close();
  }

  static int solve(String s, int c0, int c1, int h) {
    int result = 0;
    for (char ch : s.toCharArray()) {
      if ((ch == '0' && c1 + h < c0) || (ch == '1' && c0 + h < c1)) {
        result += h;
        ch = (char) ('0' + '1' - ch);
      }

      result += (ch == '0') ? c0 : c1;
    }

    return result;
  }
}
