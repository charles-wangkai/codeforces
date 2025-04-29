import java.util.Scanner;

public class Main {
  static final int SIZE = 8;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String rookPos = sc.next();
    String knightPos = sc.next();

    System.out.println(solve(rookPos, knightPos));

    sc.close();
  }

  static int solve(String rookPos, String knightPos) {
    Point rook = toPoint(rookPos);
    Point knight = toPoint(knightPos);

    int result = 0;
    for (int r = 0; r < SIZE; ++r) {
      for (int c = 0; c < SIZE; ++c) {
        Point point = new Point(r, c);
        if (!point.equals(rook)
            && !point.equals(knight)
            && !isBeatFromRook(rook, point)
            && !isBeatFromKnight(knight, point)
            && !isBeatFromKnight(point, rook)
            && !isBeatFromKnight(point, knight)) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean isBeatFromKnight(Point from, Point to) {
    return Math.abs((to.r() - from.r()) * (to.c() - from.c())) == 2;
  }

  static boolean isBeatFromRook(Point from, Point to) {
    return to.r() == from.r() || to.c() == from.c();
  }

  static Point toPoint(String pos) {
    return new Point(pos.charAt(0) - 'a', pos.charAt(1) - '1');
  }
}

record Point(int r, int c) {}
