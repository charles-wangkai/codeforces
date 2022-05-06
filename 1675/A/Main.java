import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(a, b, c, x, y) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int a, int b, int c, int x, int y) {
    return Math.max(0, x - a) + Math.max(0, y - b) <= c;
  }
}