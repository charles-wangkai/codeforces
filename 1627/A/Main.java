import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int r = sc.nextInt() - 1;
      int c = sc.nextInt() - 1;
      char[][] cells = new char[n][m];
      for (int i = 0; i < n; ++i) {
        String line = sc.next();
        for (int j = 0; j < m; ++j) {
          cells[i][j] = line.charAt(j);
        }
      }

      System.out.println(solve(cells, r, c));
    }

    sc.close();
  }

  static int solve(char[][] cells, int r, int c) {
    int n = cells.length;
    int m = cells[0].length;

    if (cells[r][c] == 'B') {
      return 0;
    }
    if (Arrays.stream(cells).allMatch(row -> new String(row).indexOf('B') == -1)) {
      return -1;
    }

    return (IntStream.range(0, n).anyMatch(i -> i != r && cells[i][c] == 'B')
            || IntStream.range(0, m).anyMatch(j -> j != c && cells[r][j] == 'B'))
        ? 1
        : 2;
  }
}
