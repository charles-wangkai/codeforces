import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int a, int b, int c) {
    return (b * 2 - c >= 1 && (b * 2 - c) % a == 0)
        || (a + c) % (2 * b) == 0
        || (b * 2 - a >= 1 && (b * 2 - a) % c == 0);
  }
}
