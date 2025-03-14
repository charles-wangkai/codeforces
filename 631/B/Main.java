import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] kinds = new int[k];
    int[] locations = new int[k];
    int[] colors = new int[k];
    for (int i = 0; i < k; ++i) {
      kinds[i] = sc.nextInt();
      locations[i] = sc.nextInt();
      colors[i] = sc.nextInt();
    }

    System.out.println(solve(n, m, kinds, locations, colors));

    sc.close();
  }

  static String solve(int n, int m, int[] kinds, int[] locations, int[] colors) {
    int[] rowIndices = new int[n];
    Arrays.fill(rowIndices, -1);

    int[] colIndices = new int[m];
    Arrays.fill(colIndices, -1);

    for (int i = 0; i < kinds.length; ++i) {
      if (kinds[i] == 1) {
        rowIndices[locations[i] - 1] = i;
      } else {
        colIndices[locations[i] - 1] = i;
      }
    }

    int[][] result = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        int index = Math.max(rowIndices[r], colIndices[c]);
        if (index != -1) {
          result[r][c] = colors[index];
        }
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}