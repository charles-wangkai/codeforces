import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int g = sc.nextInt();

      System.out.println(solve(n, k, g));
    }

    sc.close();
  }

  static long solve(int n, int k, int g) {
    return Math.min(k, (g - 1L) / 2 * n / g) * g;
  }
}
