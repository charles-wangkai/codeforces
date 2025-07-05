import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] a = new int[2][n - 1];
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(int[][] a, int[] b) {
    int n = b.length;

    int[] leftSums = new int[n];
    for (int i = 1; i < leftSums.length; ++i) {
      leftSums[i] = leftSums[i - 1] + a[0][i - 1];
    }

    int[] rightSums = new int[n];
    for (int i = rightSums.length - 2; i >= 0; --i) {
      rightSums[i] = rightSums[i + 1] + a[1][i];
    }

    return IntStream.range(0, n)
        .map(i -> leftSums[i] + rightSums[i] + b[i])
        .sorted()
        .limit(2)
        .sum();
  }
}