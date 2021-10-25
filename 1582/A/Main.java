import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static int solve(int a, int b, int c) {
    if (a >= 4) {
      a = (a % 2 == 0) ? 4 : 3;
    }
    if (b >= 4) {
      b = (b % 2 == 0) ? 4 : 3;
    }
    c %= 2;

    int result = Integer.MAX_VALUE;
    int sum = a + b * 2 + c * 3;
    for (int i = 0; i <= a; ++i) {
      for (int j = 0; j <= b; ++j) {
        for (int k = 0; k <= c; ++k) {
          result = Math.min(result, Math.abs(sum - (i + j * 2 + k * 3) * 2));
        }
      }
    }

    return result;
  }
}
