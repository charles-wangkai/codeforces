import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    int[][] result = new int[2][n];
    result[0][0] = 2 * n;
    result[1][n - 1] = 2 * n - 1;
    int lower = 1;
    int upper = 2 * n - 3;
    for (int i = 0; i < n - 1; ++i) {
      if (i % 2 == 0) {
        result[1][i] = lower;
        result[0][i + 1] = lower + 1;
        lower += 2;
      } else {
        result[1][i] = upper;
        result[0][i + 1] = upper + 1;
        upper -= 2;
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}
