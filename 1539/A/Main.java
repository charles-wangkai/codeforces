import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();
    for (int tc = 0; tc < k; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int t = sc.nextInt();

      System.out.println(solve(n, x, t));
    }

    sc.close();
  }

  static long solve(int n, int x, int t) {
    int limit = Math.min(n - 1, t / x);

    return (n - limit - 1L) * limit + limit * (limit + 1L) / 2;
  }
}
