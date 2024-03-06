import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(n, s));
    }

    sc.close();
  }

  static String solve(int n, String s) {
    if (n % 2 == 1) {
      return solve(n - 1, reverse(s));
    }

    return (s.compareTo(reverse(s)) <= 0) ? s : (reverse(s) + s);
  }

  static String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }
}