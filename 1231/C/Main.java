import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] a = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        a[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    for (int r = n - 2; r >= 1; --r) {
      for (int c = m - 2; c >= 1; --c) {
        if (a[r][c] == 0) {
          a[r][c] = Math.min(a[r + 1][c], a[r][c + 1]) - 1;
        }
      }
    }

    return (Arrays.stream(a)
                .allMatch(line -> IntStream.range(0, m - 1).allMatch(c -> line[c] < line[c + 1]))
            && IntStream.range(0, m)
                .allMatch(c -> IntStream.range(0, n - 1).allMatch(r -> a[r][c] < a[r + 1][c])))
        ? Arrays.stream(a).mapToInt(line -> Arrays.stream(line).sum()).sum()
        : -1;
  }
}