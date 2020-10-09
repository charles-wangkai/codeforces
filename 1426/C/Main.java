import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    int result = n - 1;
    for (int i = 2; i - 1 < result; ++i) {
      result = Math.min(result, i - 1 + (n + i - 1) / i - 1);
    }

    return result;
  }
}
