import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int x2 = sc.nextInt();
    int y2 = sc.nextInt();
    int x3 = sc.nextInt();
    int y3 = sc.nextInt();
    int x4 = sc.nextInt();
    int y4 = sc.nextInt();
    int x5 = sc.nextInt();
    int y5 = sc.nextInt();
    int x6 = sc.nextInt();
    int y6 = sc.nextInt();

    System.out.println(solve(x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(
      int x1,
      int y1,
      int x2,
      int y2,
      int x3,
      int y3,
      int x4,
      int y4,
      int x5,
      int y5,
      int x6,
      int y6) {
    x1 *= 2;
    y1 *= 2;
    x2 *= 2;
    y2 *= 2;
    x3 *= 2;
    y3 *= 2;
    x4 *= 2;
    y4 *= 2;
    x5 *= 2;
    y5 *= 2;
    x6 *= 2;
    y6 *= 2;

    int[] candidateXs =
        IntStream.of(x1, x2, x3, x4, x5, x6)
            .flatMap(x -> IntStream.of(x - 1, x, x + 1))
            .distinct()
            .toArray();
    int[] candidateYs =
        IntStream.of(y1, y2, y3, y4, y5, y6)
            .flatMap(y -> IntStream.of(y - 1, y, y + 1))
            .distinct()
            .toArray();

    for (int x : candidateXs) {
      for (int y : candidateYs) {
        if (isInside(x, y, x1, y1, x2, y2)
            && !isInside(x, y, x3, y3, x4, y4)
            && !isInside(x, y, x5, y5, x6, y6)) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean isInside(int x, int y, int minX, int minY, int maxX, int maxY) {
    return x >= minX && x <= maxX && y >= minY && y <= maxY;
  }
}