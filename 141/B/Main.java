import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(a, x, y));

    sc.close();
  }

  static int solve(int a, int x, int y) {
    if (y % a == 0) {
      return -1;
    }

    int row = Math.ceilDiv(y, a);
    int rowSize = getRowSize(row);
    int offset;
    if (rowSize == 1) {
      if (2 * x <= -a || 2 * x >= a) {
        return -1;
      }

      offset = 1;
    } else {
      if (x <= -a || x >= a || x == 0) {
        return -1;
      }

      offset = (x < 0) ? 1 : 2;
    }

    return IntStream.range(1, row).map(Main::getRowSize).sum() + offset;
  }

  static int getRowSize(int r) {
    return (r == 1) ? 1 : (r % 2 + 1);
  }
}