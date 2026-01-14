import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int s = sc.nextInt();
      int k = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(s, k, m));
    }

    sc.close();
  }

  static int solve(int s, int k, int m) {
    if (m / k % 2 == 0) {
      return Math.max(0, s - m % k);
    }

    return Math.max(0, Math.min(s, k) - m % k);
  }
}