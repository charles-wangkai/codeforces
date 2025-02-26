import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int p = sc.nextInt();

      System.out.println(solve(n, k, p));
    }

    sc.close();
  }

  static int solve(int n, int k, int p) {
    int needed = (Math.abs(k) + p - 1) / p;

    return (needed <= n) ? needed : -1;
  }
}