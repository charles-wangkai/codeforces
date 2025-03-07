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
    int digit1 = s.charAt(0) - '0';
    int digit2 = s.charAt(2) - '0';

    char comparison;
    if (digit1 < digit2) {
      comparison = '<';
    } else if (digit1 > digit2) {
      comparison = '>';
    } else {
      comparison = '=';
    }

    return "%d%c%d".formatted(digit1, comparison, digit2);
  }
}