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
    for (int result = 0; ; ++result) {
      if (check(n, result)) {
        return result;
      }
    }
  }

  static boolean check(int n, int operationNum) {
    int minDiff = 7;
    int value = n - operationNum;
    while (value != 0) {
      minDiff = Math.min(minDiff, Math.floorMod(7 - value % 10, 10));

      value /= 10;
    }

    return minDiff <= operationNum;
  }
}