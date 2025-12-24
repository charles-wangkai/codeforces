import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] A = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        A[r][c] = sc.nextInt();
      }
    }
    int[][] B = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        B[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(A, B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[][] A, int[][] B) {
    int n = A.length;
    int m = A[0].length;

    Map<Integer, Integer> rowToDiffCount = new HashMap<>();
    Map<Integer, Integer> colToDiffCount = new HashMap<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (A[r][c] != B[r][c]) {
          rowToDiffCount.put(r, rowToDiffCount.getOrDefault(r, 0) + 1);
          colToDiffCount.put(c, colToDiffCount.getOrDefault(c, 0) + 1);
        }
      }
    }

    return rowToDiffCount.values().stream().allMatch(diffCount -> diffCount % 2 == 0)
        && colToDiffCount.values().stream().allMatch(diffCount -> diffCount % 2 == 0);
  }
}