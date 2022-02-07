import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int sx = sc.nextInt();
    int sy = sc.nextInt();
    int ex = sc.nextInt();
    int ey = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s, sx, sy, ex, ey));

    sc.close();
  }

  static int solve(String s, int sx, int sy, int ex, int ey) {
    int distance = computeDistance(sx, sy, ex, ey);
    int x = sx;
    int y = sy;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      int nextX = x;
      int nextY = y;
      if (c == 'E') {
        ++nextX;
      } else if (c == 'S') {
        --nextY;
      } else if (c == 'W') {
        --nextX;
      } else {
        ++nextY;
      }
      int nextDistance = computeDistance(nextX, nextY, ex, ey);
      if (nextDistance < distance) {
        distance = nextDistance;
        x = nextX;
        y = nextY;

        if (distance == 0) {
          return i + 1;
        }
      }
    }

    return -1;
  }

  static int computeDistance(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}