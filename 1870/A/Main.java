import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int x = sc.nextInt();

      System.out.println(solve(n, k, x));
    }

    sc.close();
  }

  static int solve(int n, int k, int x) {
    if (n < k || x + 1 < k) {
      return -1;
    }

    return k * (k - 1) / 2 + (n - k) * ((x == k) ? (x - 1) : x);
  }
}
