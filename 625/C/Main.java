import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(int n, int k) {
    int value = n * n;
    int[][] table = new int[n][n];
    for (int r = 0; r < n; ++r) {
      for (int c = n - 1; c >= k - 1; --c) {
        table[r][c] = value;
        --value;
      }
    }
    for (int r = 0; r < n; ++r) {
      for (int c = k - 2; c >= 0; --c) {
        table[r][c] = value;
        --value;
      }
    }

    return "%d\n%s"
        .formatted(
            IntStream.range(0, n).map(r -> table[r][k - 1]).sum(),
            Arrays.stream(table)
                .map(
                    line ->
                        Arrays.stream(line)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n")));
  }
}