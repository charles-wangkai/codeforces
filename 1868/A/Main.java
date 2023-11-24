import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static String solve(int n, int m) {
    int[][] M = new int[n][m];
    for (int r = 0; r < m - 1 && r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        M[r][c] = (r + c) % m;
      }
    }
    for (int r = m - 1; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        M[r][c] = c;
      }
    }

    int beauty =
        mex(
            IntStream.range(0, m)
                .map(c -> mex(IntStream.range(0, n).map(r -> M[r][c]).toArray()))
                .toArray());

    return String.format(
        "%d\n%s",
        beauty,
        Arrays.stream(M)
            .map(
                line ->
                    Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
            .collect(Collectors.joining("\n")));
  }

  static int mex(int[] a) {
    Set<Integer> values = Arrays.stream(a).boxed().collect(Collectors.toSet());
    for (int i = 0; ; ++i) {
      if (!values.contains(i)) {
        return i;
      }
    }
  }
}