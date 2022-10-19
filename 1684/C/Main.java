import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] a = new int[n][m];
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < m; ++c) {
          a[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[][] a) {
    int[] columnDiffIndices =
        Arrays.stream(a)
            .flatMapToInt(
                line -> {
                  int[] sorted = Arrays.stream(line).sorted().toArray();

                  return IntStream.range(0, line.length).filter(i -> line[i] != sorted[i]);
                })
            .distinct()
            .toArray();
    if (columnDiffIndices.length >= 3) {
      return "-1";
    }
    if (columnDiffIndices.length == 0) {
      return "1 1";
    }

    for (int[] line : a) {
      int temp = line[columnDiffIndices[0]];
      line[columnDiffIndices[0]] = line[columnDiffIndices[1]];
      line[columnDiffIndices[1]] = temp;
    }

    return Arrays.stream(a)
            .allMatch(
                line -> IntStream.range(0, line.length - 1).allMatch(i -> line[i] <= line[i + 1]))
        ? String.format("%d %d", columnDiffIndices[0] + 1, columnDiffIndices[1] + 1)
        : "-1";
  }
}
