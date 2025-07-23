import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(n, s));

    sc.close();
  }

  static int solve(int n, String s) {
    int result = 0;
    for (int i = n; i < s.length(); i += n) {
      if (s.charAt(i - 1) == s.charAt(i - 2) && s.charAt(i - 2) == s.charAt(i - 3)) {
        ++result;
      }
    }

    return result;
  }
}