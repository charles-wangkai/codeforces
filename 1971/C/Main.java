import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int d = sc.nextInt();

      System.out.println(solve(a, b, c, d) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int a, int b, int c, int d) {
    if (a > b) {
      return solve(b, a, c, d);
    }

    if (b < a) {
      b += 12;
    }
    if (c < a) {
      c += 12;
    }
    if (d < a) {
      d += 12;
    }

    return c < b != d < b;
  }
}