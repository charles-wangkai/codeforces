import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }
    int[] x = new int[k];
    int[] y = new int[k];
    for (int i = 0; i < k; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(a, x, y));

    sc.close();
  }

  static String solve(int[][] a, int[] x, int[] y) {
    int n = a.length;
    int m = a[0].length;

    int[] employeeCounts = new int[n];
    int[] chatCounts = new int[m];
    for (int i = 0; i < x.length; ++i) {
      ++employeeCounts[x[i] - 1];
      ++chatCounts[y[i] - 1];
    }

    return IntStream.range(0, n)
        .map(
            i ->
                IntStream.range(0, m).filter(j -> a[i][j] == 1).map(j -> chatCounts[j]).sum()
                    - employeeCounts[i])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}