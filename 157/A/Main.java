import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] squares = new int[n][n];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        squares[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(squares));

    sc.close();
  }

  static int solve(int[][] squares) {
    int n = squares.length;

    int[] rowSums = new int[n];
    int[] colSums = new int[n];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        rowSums[r] += squares[r][c];
        colSums[c] += squares[r][c];
      }
    }

    int result = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if (colSums[c] > rowSums[r]) {
          ++result;
        }
      }
    }

    return result;
  }
}