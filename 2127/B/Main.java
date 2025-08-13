import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int x = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, x));
    }

    sc.close();
  }

  static int solve(String s, int x) {
    return Math.max(computeMinDayNum(s, x, -1), computeMinDayNum(s, x, 1));
  }

  static int computeMinDayNum(String s, int x, int offset) {
    char[] cells = s.toCharArray();

    int index = x - 1 + offset;
    if (index >= 0 && index < cells.length) {
      cells[index] = '#';
    }

    return Math.min(
        IntStream.range(0, x - 1).filter(i -> cells[i] == '#').max().orElse(-1) + 2,
        cells.length
            - IntStream.range(x, cells.length)
                .filter(i -> cells[i] == '#')
                .min()
                .orElse(cells.length)
            + 1);
  }
}