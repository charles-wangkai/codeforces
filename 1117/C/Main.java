import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(x1, y1, x2, y2, s));
    }
  }

  static long solve(int x1, int y1, int x2, int y2, String s) {
    int n = s.length();

    int[] deltaXs = new int[n + 1];
    int[] deltaYs = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      deltaXs[i] = deltaXs[i - 1];
      deltaYs[i] = deltaYs[i - 1];

      char direction = s.charAt(i - 1);
      if (direction == 'U') {
        ++deltaYs[i];
      } else if (direction == 'D') {
        --deltaYs[i];
      } else if (direction == 'L') {
        --deltaXs[i];
      } else {
        ++deltaXs[i];
      }
    }

    long result = -1;
    long lower = 0;
    long upper = computeDistance(x1, y1, x2, y2) * s.length();
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (check(x1, y1, x2, y2, deltaXs, deltaYs, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int x1, int y1, int x2, int y2, int[] deltaXs, int[] deltaYs, long step) {
    int n = deltaXs.length - 1;

    return step
        >= computeDistance(
            x1 + (step / n) * deltaXs[n] + deltaXs[(int) (step % n)],
            y1 + (step / n) * deltaYs[n] + deltaYs[(int) (step % n)],
            x2,
            y2);
  }

  static long computeDistance(long xa, long ya, long xb, long yb) {
    return Math.abs(xa - xb) + Math.abs(ya - yb);
  }
}