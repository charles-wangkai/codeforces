import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(solve(k, a, b, x, y));
    }

    sc.close();
  }

  static int solve(int k, int a, int b, int x, int y) {
    if (a < b) {
      return solve(k, b, a, y, x);
    }

    int firstPortionNum = computePortionNum(k, a, Math.min(x, y));

    return firstPortionNum + computePortionNum(k - firstPortionNum * Math.min(x, y), b, y);
  }

  static int computePortionNum(int from, int to, int decrease) {
    if (from < to) {
      return 0;
    }

    return (from - to) / decrease + 1;
  }
}