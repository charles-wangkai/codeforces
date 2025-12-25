import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int x2 = sc.nextInt();
    int y2 = sc.nextInt();
    int x3 = sc.nextInt();
    int y3 = sc.nextInt();

    System.out.println(solve(x1, y1, x2, y2, x3, y3));

    sc.close();
  }

  static String solve(int x1, int y1, int x2, int y2, int x3, int y3) {
    if (isRightAngled(x1, y1, x2, y2, x3, y3)) {
      return "RIGHT";
    }

    if (isRightAngled(x1 - 1, y1, x2, y2, x3, y3)
        || isRightAngled(x1 + 1, y1, x2, y2, x3, y3)
        || isRightAngled(x1, y1 - 1, x2, y2, x3, y3)
        || isRightAngled(x1, y1 + 1, x2, y2, x3, y3)
        || isRightAngled(x1, y1, x2 - 1, y2, x3, y3)
        || isRightAngled(x1, y1, x2 + 1, y2, x3, y3)
        || isRightAngled(x1, y1, x2, y2 - 1, x3, y3)
        || isRightAngled(x1, y1, x2, y2 + 1, x3, y3)
        || isRightAngled(x1, y1, x2, y2, x3 - 1, y3)
        || isRightAngled(x1, y1, x2, y2, x3 + 1, y3)
        || isRightAngled(x1, y1, x2, y2, x3, y3 - 1)
        || isRightAngled(x1, y1, x2, y2, x3, y3 + 1)) {
      return "ALMOST";
    }

    return "NEITHER";
  }

  static boolean isRightAngled(int x1, int y1, int x2, int y2, int x3, int y3) {
    return !isDegenerate(x1, y1, x2, y2, x3, y3)
        && (computeDotProduct(x2 - x1, y2 - y1, x3 - x1, y3 - y1) == 0
            || computeDotProduct(x1 - x2, y1 - y2, x3 - x2, y3 - y2) == 0
            || computeDotProduct(x1 - x3, y1 - y3, x2 - x3, y2 - y3) == 0);
  }

  static boolean isDegenerate(int x1, int y1, int x2, int y2, int x3, int y3) {
    return (x1 * y2 - x2 * y1) + (x2 * y3 - x3 * y2) + (x3 * y1 - x1 * y3) == 0;
  }

  static int computeDotProduct(int x1, int y1, int x2, int y2) {
    return x1 * x2 + y1 * y2;
  }
}