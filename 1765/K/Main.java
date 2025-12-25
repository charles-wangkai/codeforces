import java.util.Scanner;
import java.util.stream.IntStream;

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

  static long solve(int[][] a) {
    int n = a.length;

    long sum = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        sum += a[r][c];
      }
    }

    return sum - IntStream.range(0, n).map(i -> a[i][n - 1 - i]).min().getAsInt();
  }
}