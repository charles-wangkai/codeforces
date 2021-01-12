import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    char[] digits = new char[n];
    digits[0] = '9';
    for (int i = 1; i < digits.length; ++i) {
      digits[i] = (char) ((i + 7) % 10 + '0');
    }

    return new String(digits);
  }
}
