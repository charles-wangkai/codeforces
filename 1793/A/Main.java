import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(a, b, n, m));
    }

    sc.close();
  }

  static long solve(int a, int b, int n, int m) {
    return n / (m + 1L) * Math.min((long) m * a, (m + 1L) * b) + n % (m + 1L) * Math.min(a, b);
  }
}
