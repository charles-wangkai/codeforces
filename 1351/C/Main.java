import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String moves = sc.next();

      System.out.println(solve(moves));
    }

    sc.close();
  }

  static int solve(String moves) {
    int result = 0;
    Set<Segment> seen = new HashSet<>();
    int x = 0;
    int y = 0;
    for (char move : moves.toCharArray()) {
      int nextX;
      int nextY;
      Segment segment;
      if (move == 'S') {
        nextX = x;
        nextY = y - 1;
        segment = new Segment(x, y, nextX, nextY);
      } else if (move == 'N') {
        nextX = x;
        nextY = y + 1;
        segment = new Segment(nextX, nextY, x, y);
      } else if (move == 'W') {
        nextX = x - 1;
        nextY = y;
        segment = new Segment(nextX, nextY, x, y);
      } else {
        nextX = x + 1;
        nextY = y;
        segment = new Segment(x, y, nextX, nextY);
      }

      if (seen.contains(segment)) {
        ++result;
      } else {
        seen.add(segment);
        result += 5;
      }

      x = nextX;
      y = nextY;
    }

    return result;
  }
}

record Segment(int x1, int y1, int x2, int y2) {}
