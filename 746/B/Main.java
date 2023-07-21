import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();
    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    String result = "";
    boolean leftAppend = s.length() % 2 == 0;
    while (result.length() < s.length()) {
      if (leftAppend) {
        result = s.charAt(result.length()) + result;
      } else {
        result += s.charAt(result.length());
      }

      leftAppend = !leftAppend;
    }
    return result;
  }
}
