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
    int solutionNum1 = 1;
    if (k == 1) {
      return solutionNum1;
    }

    int solutionNum2 = Math.min(m, n - 1) + m / n;
    if (k == 2) {
      return solutionNum2;
    }

    if (k == 3) {
      return (m + 1) - solutionNum1 - solutionNum2;
    }

    return 0;
  }
}