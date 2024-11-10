import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] cells = new int[n][m];
      for (int r = 0; r < n; ++r) {
        String line = sc.next();
        for (int c = 0; c < m; ++c) {
          cells[r][c] = line.charAt(c) - '0';
        }
      }

      System.out.println(solve(cells));
    }

    sc.close();
  }

  static int solve(int[][] cells) {
    int n = cells.length;
    int m = cells[0].length;

    int result = 0;
    int lowerR = 0;
    int upperR = n - 1;
    int lowerC = 0;
    int upperC = m - 1;
    while (lowerR < upperR && lowerC < upperC) {
      List<Integer> values = new ArrayList<>();
      for (int c = lowerC; c < upperC; ++c) {
        values.add(cells[lowerR][c]);
      }
      for (int r = lowerR; r < upperR; ++r) {
        values.add(cells[r][upperC]);
      }
      for (int c = upperC; c > lowerC; --c) {
        values.add(cells[upperR][c]);
      }
      for (int r = upperR; r > lowerR; --r) {
        values.add(cells[r][lowerC]);
      }

      result +=
          IntStream.range(0, values.size())
              .filter(
                  i ->
                      values.get(i) == 1
                          && values.get((i + 1) % values.size()) == 5
                          && values.get((i + 2) % values.size()) == 4
                          && values.get((i + 3) % values.size()) == 3)
              .count();

      ++lowerR;
      --upperR;
      ++lowerC;
      --upperC;
    }

    return result;
  }
}