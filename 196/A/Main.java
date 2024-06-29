import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    StringBuilder result = new StringBuilder().append(s.charAt(s.length() - 1));
    for (int i = s.length() - 2; i >= 0; --i) {
      char letter = s.charAt(i);
      if (letter >= result.charAt(result.length() - 1)) {
        result.append(letter);
      }
    }
    result.reverse();

    return result.toString();
  }
}