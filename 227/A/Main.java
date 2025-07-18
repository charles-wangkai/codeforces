import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int xa = sc.nextInt();
    int ya = sc.nextInt();
    int xb = sc.nextInt();
    int yb = sc.nextInt();
    int xc = sc.nextInt();
    int yc = sc.nextInt();

    System.out.println(solve(xa, ya, xb, yb, xc, yc));

    sc.close();
  }

  static String solve(int xa, int ya, int xb, int yb, int xc, int yc) {
    long cp = computeCrossProduct(new Point(xa, ya), new Point(xb, yb), new Point(xc, yc));

    if (cp < 0) {
      return "RIGHT";
    }
    if (cp > 0) {
      return "LEFT";
    }

    return "TOWARDS";
  }

  static long computeCrossProduct(Point o, Point p1, Point p2) {
    return (long) (p1.x() - o.x()) * (p2.y() - o.y()) - (long) (p2.x() - o.x()) * (p1.y() - o.y());
  }
}

record Point(int x, int y) {}
