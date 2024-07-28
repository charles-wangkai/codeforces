import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();

      System.out.println(solve(n, x));
    }

    sc.close();
  }

  static long solve(int n, int x) {
    long result = 0;
    for (int a = 1; a < n; ++a) {
      for (int b = 1; a * b < n; ++b) {
        result += Math.max(0, Math.min((n - a * b) / (a + b), x - a - b));
      }
    }

    return result;
  }
}