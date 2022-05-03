import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t));
    }

    sc.close();
  }

  static long solve(String s, String t) {
    if (t.indexOf('a') == -1) {
      return 1L << s.length();
    }

    return (t.length() == 1) ? 1 : -1;
  }
}