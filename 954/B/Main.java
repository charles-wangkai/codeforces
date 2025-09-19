import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    int result = s.length();
    for (int length = 1; length * 2 <= s.length(); ++length) {
      if (s.startsWith(s.substring(0, length).repeat(2))) {
        result = Math.min(result, length + 1 + (s.length() - length * 2));
      }
    }

    return result;
  }
}