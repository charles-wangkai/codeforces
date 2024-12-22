import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int h = sc.nextInt();
      int w = sc.nextInt();
      int xa = sc.nextInt();
      int ya = sc.nextInt();
      int xb = sc.nextInt();
      int yb = sc.nextInt();

      System.out.println(solve(h, w, xa, ya, xb, yb));
    }

    sc.close();
  }

  static String solve(int h, int w, int xa, int ya, int xb, int yb) {
    if (xa < xb) {
      int bMove = (xb - xa) / 2;
      int aMove = (xb - xa) - bMove;

      if ((xb - xa) % 2 == 1) {
        if (Math.abs(ya - yb) <= 1
            || (ya < yb && ya + aMove >= w)
            || (ya > yb && ya - aMove <= 1)) {
          return "Alice";
        }
      } else if (yb == ya || (yb < ya && yb + bMove >= w) || (yb > ya && yb - bMove <= 1)) {
        return "Bob";
      }
    }

    return "Draw";
  }
}