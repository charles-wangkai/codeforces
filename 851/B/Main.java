import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int ax = sc.nextInt();
    int ay = sc.nextInt();
    int bx = sc.nextInt();
    int by = sc.nextInt();
    int cx = sc.nextInt();
    int cy = sc.nextInt();

    System.out.println(solve(ax, ay, bx, by, cx, cy) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int ax, int ay, int bx, int by, int cx, int cy) {
    return (long) (ax - bx) * (ax - bx) + (long) (ay - by) * (ay - by)
            == (long) (bx - cx) * (bx - cx) + (long) (by - cy) * (by - cy)
        && !(bx - ax == cx - bx && by - ay == cy - by);
  }
}