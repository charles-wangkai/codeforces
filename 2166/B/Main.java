import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int n = sc.nextInt();

      System.out.println(solve(a, b, n));
    }

    sc.close();
  }

  static int solve(int a, int b, int n) {
    return ((long) b * n <= a || a == b) ? 1 : 2;
  }
}