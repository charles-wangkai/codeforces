import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int c1 = sc.nextInt();
      int c2 = sc.nextInt();
      int c3 = sc.nextInt();
      int a1 = sc.nextInt();
      int a2 = sc.nextInt();
      int a3 = sc.nextInt();
      int a4 = sc.nextInt();
      int a5 = sc.nextInt();

      System.out.println(solve(c1, c2, c3, a1, a2, a3, a4, a5) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int c1, int c2, int c3, int a1, int a2, int a3, int a4, int a5) {
    if (a1 > c1 || a2 > c2 || a3 > c3) {
      return false;
    }

    c1 -= a1;
    c2 -= a2;
    c3 -= a3;

    return Math.max(0, a4 - c1) + Math.max(0, a5 - c2) <= c3;
  }
}