import java.util.Scanner;

public class Main {
  static final int SIZE = 5;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b) ? "WIN" : "FAIL");

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    boolean[][] adjMatrix = new boolean[SIZE][SIZE];
    for (int i = 0; i < a.length; ++i) {
      adjMatrix[a[i] - 1][b[i] - 1] = true;
      adjMatrix[b[i] - 1][a[i] - 1] = true;
    }

    for (int i = 0; i < SIZE; ++i) {
      for (int j = i + 1; j < SIZE; ++j) {
        for (int k = j + 1; k < SIZE; ++k) {
          if ((adjMatrix[i][j] && adjMatrix[j][k] && adjMatrix[k][i])
              || (!adjMatrix[i][j] && !adjMatrix[j][k] && !adjMatrix[k][i])) {
            return true;
          }
        }
      }
    }

    return false;
  }
}