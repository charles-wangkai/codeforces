import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int x = sc.nextInt();
      long k = sc.nextLong();
      String s = sc.next();

      System.out.println(solve(s, x, k));
    }

    sc.close();
  }

  static long solve(String s, int x, long k) {
    int stepNum1 = computeStepNum(s, x);
    if (stepNum1 > k) {
      return 0;
    }

    int stepNum2 = computeStepNum(s, 0);
    if (stepNum2 == Integer.MAX_VALUE) {
      return 1;
    }

    return 1 + (k - stepNum1) / stepNum2;
  }

  static int computeStepNum(String s, int x) {
    for (int i = 0; i < s.length(); ++i) {
      x += (s.charAt(i) == 'L') ? -1 : 1;
      if (x == 0) {
        return i + 1;
      }
    }

    return Integer.MAX_VALUE;
  }
}