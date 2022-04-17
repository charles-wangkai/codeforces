import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(a, b, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int a, int b, int k) {
    if (a < b) {
      return solve(b, a, k);
    }

    if (k == 1) {
      return a != b && a % b == 0;
    }

    return computeExponentSum(a) + computeExponentSum(b) >= k;
  }

  static int computeExponentSum(int x) {
    int result = 0;
    for (int i = 2; i * i <= x; ++i) {
      while (x % i == 0) {
        x /= i;
        ++result;
      }
    }
    if (x != 1) {
      ++result;
    }

    return result;
  }
}