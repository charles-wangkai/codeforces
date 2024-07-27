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
    int result = Integer.MAX_VALUE;
    for (int chicken = 0; chicken * 2 <= n; ++chicken) {
      if ((n - chicken * 2) % 4 == 0) {
        result = Math.min(result, chicken + (n - chicken * 2) / 4);
      }
    }

    return result;
  }
}