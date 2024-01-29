import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int n = sc.nextInt();

      System.out.println(solve(x, n));
    }

    sc.close();
  }

  static int solve(int x, int n) {
    int result = -1;
    for (int i = 1; i * i <= x; ++i) {
      if (x % i == 0) {
        if (i >= n) {
          result = Math.max(result, x / i);
        }
        if (x / i >= n) {
          result = Math.max(result, i);
        }
      }
    }

    return result;
  }
}