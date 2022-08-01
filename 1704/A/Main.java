import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String a, String b) {
    return a.endsWith(b.substring(1))
        && a.substring(0, a.length() - b.length() + 1).indexOf(b.charAt(0)) >= 0;
  }
}