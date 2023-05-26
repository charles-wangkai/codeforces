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

  static String solve(String s) {
    char[] result = s.toCharArray();
    for (int i = 0; i < result.length; ++i) {
      if (result[i] == '?') {
        result[i] = (i == 0 || result[i - 1] == '0') ? '0' : '1';
      }
    }

    return new String(result);
  }
}
