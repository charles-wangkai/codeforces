import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(n, a, b));
    }

    sc.close();
  }

  static long solve(int n, int a, int b) {
    int k = Math.clamp(b - a, 0, n);

    return ((long) k * b - k * (k - 1L) / 2) + (long) (n - k) * a;
  }
}