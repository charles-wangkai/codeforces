import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] a = new int[n][n];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        a[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[][] a) {
    int n = a.length;

    int result = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if (r == c || r + c == n - 1 || r == n / 2 || c == n / 2) {
          result += a[r][c];
        }
      }
    }

    return result;
  }
}