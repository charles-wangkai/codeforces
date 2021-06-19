import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int i = sc.nextInt();
      int j = sc.nextInt();

      System.out.println(solve(n, m, i, j));
    }

    sc.close();
  }

  static String solve(int n, int m, int i, int j) {
    long maxDistance = -1;
    int resultX1 = -1;
    int resultY1 = -1;
    int resultX2 = -1;
    int resultY2 = -1;
    for (int x1 : new int[] {1, n}) {
      for (int y1 : new int[] {1, m}) {
        for (int x2 : new int[] {1, n}) {
          for (int y2 : new int[] {1, m}) {
            long distance =
                Math.min(
                    computeDistance(i, j, x1, y1, x2, y2), computeDistance(i, j, x2, y2, x1, y1));
            if (distance > maxDistance) {
              maxDistance = distance;
              resultX1 = x1;
              resultY1 = y1;
              resultX2 = x2;
              resultY2 = y2;
            }
          }
        }
      }
    }

    return String.format("%d %d %d %d", resultX1, resultY1, resultX2, resultY2);
  }

  static long computeDistance(int i, int j, int x1, int y1, int x2, int y2) {
    return (long) computeManhattanDistance(i, j, x1, y1)
        + computeManhattanDistance(x1, y1, x2, y2)
        + computeManhattanDistance(x2, y2, i, j);
  }

  static int computeManhattanDistance(int fromX, int fromY, int toX, int toY) {
    return Math.abs(fromX - toX) + Math.abs(fromY - toY);
  }
}
