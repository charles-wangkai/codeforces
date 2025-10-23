import java.util.Scanner;

public class Main {
  static final int[] X_OFFSETS = {1, 0, -1, 0};
  static final int[] Y_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int x, int y) {
    if (x == 0 && y == 0) {
      return 0;
    }

    int result = 0;
    int currentX = 0;
    int currentY = 0;
    int direction = 0;
    for (int step = 1; ; ++step) {
      for (int i = 0; i < 2; ++i) {
        for (int j = 0; j < step; ++j) {
          currentX += X_OFFSETS[direction];
          currentY += Y_OFFSETS[direction];
          if (currentX == x && currentY == y) {
            return result;
          }
        }

        direction = (direction + 1) % X_OFFSETS.length;
        ++result;
      }
    }
  }
}