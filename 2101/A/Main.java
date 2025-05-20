import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int[] R_OFFSETS = {0, 1, 0, -1};
  static final int[] C_OFFSETS = {1, 0, -1, 0};

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
    int[][] result = new int[n][n];
    for (int r = 0; r < result.length; ++r) {
      Arrays.fill(result[r], -1);
    }

    int direction = 0;
    int r = 0;
    int c = -1;
    for (int i = n * n - 1; i >= 0; --i) {
      int nextR = r + R_OFFSETS[direction];
      int nextC = c + C_OFFSETS[direction];
      if (!(nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && result[nextR][nextC] == -1)) {
        direction = (direction + 1) % R_OFFSETS.length;

        nextR = r + R_OFFSETS[direction];
        nextC = c + C_OFFSETS[direction];
      }

      result[nextR][nextC] = i;

      r = nextR;
      c = nextC;
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}