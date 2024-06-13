import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    int result = 0;
    int count = 0;
    for (int i = 0; i <= s.length(); ++i) {
      if (i != s.length() && i != 0 && s.charAt(i) == s.charAt(i - 1)) {
        ++count;
      } else {
        result += (count + 4) / 5;
        count = 1;
      }
    }

    return result;
  }
}