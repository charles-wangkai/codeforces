import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println(solve(p));

    sc.close();
  }

  static String solve(int[] p) {
    int[][] result = new int[p.length][];
    for (int i = 0; i < result.length; ++i) {
      result[i] = new int[i + 1];
    }

    for (int i = 0; i < p.length; ++i) {
      int r = i;
      int c = i;
      result[r][c] = p[i];
      for (int j = 0; j < p[i] - 1; ++j) {
        if (c != 0 && result[r][c - 1] == 0) {
          --c;
        } else {
          ++r;
        }

        result[r][c] = p[i];
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}
