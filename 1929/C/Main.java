import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      int x = sc.nextInt();
      int a = sc.nextInt();

      System.out.println(solve(k, x, a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int k, int x, int a) {
    int sum = 0;
    for (int i = 1; i <= x; ++i) {
      sum += Math.max(1, (sum + k - 1) / (k - 1));
      if (sum > a) {
        return false;
      }
    }

    return (a - sum) * (k - 1L) > sum;
  }
}