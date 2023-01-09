import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

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
    int r = 0;
    int c = -1;
    int direction = 1;
    int lower = 1;
    int upper = n * n;
    for (int i = 0; i < n * n; ++i) {
      if (!(r + R_OFFSETS[direction] >= 0
          && r + R_OFFSETS[direction] < n
          && c + C_OFFSETS[direction] >= 0
          && c + C_OFFSETS[direction] < n
          && result[r + R_OFFSETS[direction]][c + C_OFFSETS[direction]] == 0)) {
        direction = (direction + 1) % R_OFFSETS.length;
      }
      r += R_OFFSETS[direction];
      c += C_OFFSETS[direction];

      if (i % 2 == 0) {
        result[r][c] = lower;
        ++lower;
      } else {
        result[r][c] = upper;
        --upper;
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}
