import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] rows = new int[n][m];
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < m; ++c) {
          rows[r][c] = sc.nextInt();
        }
      }
      int[][] cols = new int[m][n];
      for (int c = 0; c < m; ++c) {
        for (int r = 0; r < n; ++r) {
          cols[c][r] = sc.nextInt();
        }
      }

      System.out.print(solve(rows, cols));
    }

    sc.close();
  }

  static String solve(int[][] rows, int[][] cols) {
    int n = rows.length;
    int m = rows[0].length;

    int[] rowIndices = new int[n * m + 1];
    for (int[] col : cols) {
      for (int r = 0; r < col.length; ++r) {
        rowIndices[col[r]] = r;
      }
    }

    int[][] table =
        Arrays.stream(rows)
            .sorted(Comparator.comparing(row -> rowIndices[row[0]]))
            .toArray(int[][]::new);

    StringBuilder result = new StringBuilder();
    for (int[] line : table) {
      for (int i = 0; i < line.length; ++i) {
        if (i != 0) {
          result.append(" ");
        }
        result.append(line[i]);
      }
      result.append("\n");
    }

    return result.toString();
  }
}
