import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String a = sc.next();
      sc.nextInt();
      String b = sc.next();
      String c = sc.next();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static String solve(String a, String b, String c) {
    String result = a;
    for (int i = 0; i < b.length(); ++i) {
      if (c.charAt(i) == 'V') {
        result = b.charAt(i) + result;
      } else {
        result += b.charAt(i);
      }
    }

    return result;
  }
}