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
    if ((a + b + c) % 9 != 0) {
      return false;
    }

    int round = (a + b + c) / 9;

    return a >= round && b >= round && c >= round;
  }
}
