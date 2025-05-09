import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    String[] names = new String[n];
    int[][] a = new int[n][m];
    int[][] b = new int[n][m];
    int[][] c = new int[n][m];
    for (int i = 0; i < n; ++i) {
      names[i] = sc.next();
      for (int j = 0; j < m; ++j) {
        a[i][j] = sc.nextInt();
        b[i][j] = sc.nextInt();
        c[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(names, a, b, c, k));

    sc.close();
  }

  static int solve(String[] names, int[][] a, int[][] b, int[][] c, int k) {
    int n = names.length;
    int m = a[0].length;

    int result = 0;
    for (int from = 0; from < n; ++from) {
      for (int to = 0; to < n; ++to) {
        int from_ = from;
        int to_ = to;
        result =
            Math.max(
                result,
                IntStream.range(0, m)
                    .flatMap(
                        i ->
                            IntStream.range(0, c[from_][i])
                                .map(j -> Math.max(0, b[to_][i] - a[from_][i])))
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .limit(k)
                    .mapToInt(Integer::intValue)
                    .sum());
      }
    }

    return result;
  }
}