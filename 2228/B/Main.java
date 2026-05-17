import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x1 = sc.nextInt();
      int x2 = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, x1, x2, k));
    }

    sc.close();
  }

  static int solve(int n, int x1, int x2, int k) {
    if (n <= 3) {
      return 1;
    }

    return k + Math.min(Math.abs(x1 - x2), n - Math.abs(x1 - x2));
  }
}