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
    int result = 0;
    int lastIndex = -1;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == 'B') {
        int delta = i - lastIndex - 1;
        result += delta;
        lastIndex = i - ((delta == 0) ? 0 : 1);
      }
    }

    return result;
  }
}