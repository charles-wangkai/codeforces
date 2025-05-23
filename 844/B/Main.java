import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] cells = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        cells[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(cells));

    sc.close();
  }

  static long solve(int[][] cells) {
    int n = cells.length;
    int m = cells[0].length;

    long result = n * m;
    for (int r = 0; r < n; ++r) {
      int[] counts = new int[2];
      for (int c = 0; c < m; ++c) {
        ++counts[cells[r][c]];
      }

      result += computeSetNum(counts[0]) + computeSetNum(counts[1]);
    }
    for (int c = 0; c < m; ++c) {
      int[] counts = new int[2];
      for (int r = 0; r < n; ++r) {
        ++counts[cells[r][c]];
      }

      result += computeSetNum(counts[0]) + computeSetNum(counts[1]);
    }

    return result;
  }

  static long computeSetNum(int size) {
    return (1L << size) - 1 - size;
  }
}