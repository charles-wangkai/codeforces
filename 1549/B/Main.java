import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String top = sc.next();
      String down = sc.next();

      System.out.println(solve(top, down));
    }

    sc.close();
  }

  static int solve(String top, String down) {
    int result = 0;
    char[] own = down.toCharArray();
    for (int i = 0; i < top.length(); ++i) {
      if (top.charAt(i) == '0') {
        if (own[i] == '1') {
          own[i] = '0';
          ++result;
        }
      } else {
        if (i != 0 && own[i - 1] == '1') {
          own[i - 1] = '0';
          ++result;
        } else if (i != top.length() - 1 && own[i + 1] == '1') {
          own[i + 1] = '0';
          ++result;
        }
      }
    }

    return result;
  }
}
