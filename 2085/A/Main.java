import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, int k) {
    return s.chars().distinct().count() != 1
        && (k != 0 || s.compareTo(new StringBuilder(s).reverse().toString()) < 0);
  }
}