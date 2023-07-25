import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static int solve(int n, int k) {
    int prevCoef1 = 1;
    int coef1 = 0;
    int prevCoef2 = 0;
    int coef2 = 1;
    for (int i = 3; i <= k; ++i) {
      int nextCoef1 = prevCoef1 + coef1;
      prevCoef1 = coef1;
      coef1 = nextCoef1;

      int nextCoef2 = prevCoef2 + coef2;
      prevCoef2 = coef2;
      coef2 = nextCoef2;

      if (coef1 > n && coef2 > n) {
        return 0;
      }
    }

    int result = 0;
    for (int a = 0; a * (coef1 + coef2) <= n; ++a) {
      if ((n - a * coef1) % coef2 == 0) {
        ++result;
      }
    }

    return result;
  }
}
