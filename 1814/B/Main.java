import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int a, int b) {
    int result = Integer.MAX_VALUE;
    for (int m = 1; m - 1 < result; ++m) {
      result = Math.min(result, (m - 1) + (a + m - 1) / m + (b + m - 1) / m);
    }

    return result;
  }
}