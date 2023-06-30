import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int xA = sc.nextInt();
      int yA = sc.nextInt();
      int xB = sc.nextInt();
      int yB = sc.nextInt();
      int xC = sc.nextInt();
      int yC = sc.nextInt();

      System.out.println(solve(xA, yA, xB, yB, xC, yC));
    }

    sc.close();
  }

  static int solve(int xA, int yA, int xB, int yB, int xC, int yC) {
    return computeCommon(xA, xB, xC) + computeCommon(yA, yB, yC) + 1;
  }

  static int computeCommon(int a, int b, int c) {
    int diff1 = b - a;
    int diff2 = c - a;

    return (Integer.signum(diff1) == Integer.signum(diff2))
        ? Math.min(Math.abs(diff1), Math.abs(diff2))
        : 0;
  }
}
