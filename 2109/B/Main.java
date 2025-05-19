import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(n, m, a, b));
    }

    sc.close();
  }

  static int solve(int n, int m, int a, int b) {
    return Math.min(
        1 + computeCutNum(Math.min(a, n - a + 1)) + computeCutNum(m),
        1 + computeCutNum(Math.min(b, m - b + 1)) + computeCutNum(n));
  }

  static int computeCutNum(int length) {
    if (length == 1) {
      return 0;
    }

    return 1 + computeCutNum((length + 1) / 2);
  }
}