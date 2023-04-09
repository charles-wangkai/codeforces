import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();

      System.out.println(solve(n, m, x1, y1, x2, y2));
    }

    sc.close();
  }

  static int solve(int n, int m, int x1, int y1, int x2, int y2) {
    return IntStream.of(
            n,
            m,
            computeNeighborNum(n, m, x1 - 1, y1 - 1),
            computeNeighborNum(n, m, x2 - 1, y2 - 1))
        .min()
        .getAsInt();
  }

  static int computeNeighborNum(int n, int m, int r, int c) {
    return (int)
        IntStream.range(0, R_OFFSETS.length)
            .filter(
                i -> {
                  int adjR = r + R_OFFSETS[i];
                  int adjC = c + C_OFFSETS[i];

                  return adjR >= 0 && adjR < n && adjC >= 0 && adjC < m;
                })
            .count();
  }
}
