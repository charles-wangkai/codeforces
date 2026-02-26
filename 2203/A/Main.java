import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int d = sc.nextInt();

      System.out.println(solve(n, m, d));
    }

    sc.close();
  }

  static int solve(int n, int m, int d) {
    return Math.ceilDiv(n, d / m + 1);
  }
}