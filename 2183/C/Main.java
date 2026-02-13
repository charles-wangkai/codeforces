import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, m, k));
    }

    sc.close();
  }

  static int solve(int n, int m, int k) {
    int result = 1;
    for (int left = 0; left <= k - 1; ++left) {
      int rest = m - Math.max(0, (left - 1) + left);
      if (rest >= 0) {
        int right = Math.min(Math.min(n - k, rest), (rest + Math.max(1, left)) / 2);

        result = Math.max(result, left + right + 1);
      }
    }

    return result;
  }
}