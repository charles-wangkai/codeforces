import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] g = new int[n][n];
      for (int i = 0; i < g.length; ++i) {
        String line = sc.next();
        for (int j = 0; j < g[i].length; ++j) {
          g[i][j] = line.charAt(j) - '0';
        }
      }

      System.out.println(solve(g));
    }

    sc.close();
  }

  static String solve(int[][] g) {
    int n = g.length;

    int[] result = new int[n];
    for (int i = 0; i < n; ++i) {
      int sequence = 0;
      for (int j = i + 1; j < n; ++j) {
        if (g[i][j] == 0) {
          ++sequence;
        }
      }

      int index = 0;
      while (true) {
        while (result[index] != 0) {
          ++index;
        }

        if (sequence == 0) {
          result[index] = i + 1;

          break;
        }

        ++index;
        --sequence;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}