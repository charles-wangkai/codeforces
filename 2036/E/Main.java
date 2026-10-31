import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int q = sc.nextInt();
    int[][] a = new int[n][k];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < k; ++c) {
        a[r][c] = sc.nextInt();
      }
    }
    int[][] regionQueries = new int[q][];
    char[][] signQueries = new char[q][];
    int[][] valueQueries = new int[q][];
    for (int i = 0; i < q; ++i) {
      int m = sc.nextInt();
      regionQueries[i] = new int[m];
      signQueries[i] = new char[m];
      valueQueries[i] = new int[m];
      for (int j = 0; j < m; ++j) {
        regionQueries[i][j] = sc.nextInt();
        signQueries[i][j] = sc.next().charAt(0);
        valueQueries[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(a, regionQueries, signQueries, valueQueries));

    sc.close();
  }

  static String solve(
      int[][] a, int[][] regionQueries, char[][] signQueries, int[][] valueQueries) {
    int n = a.length;
    int k = a[0].length;

    int[][] b = new int[n][k];
    for (int c = 0; c < k; ++c) {
      for (int r = 0; r < n; ++r) {
        b[r][c] = ((r == 0) ? 0 : b[r - 1][c]) | a[r][c];
      }
    }

    return IntStream.range(0, regionQueries.length)
        .map(i -> findCountry(b, regionQueries[i], signQueries[i], valueQueries[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int findCountry(int[][] b, int[] regions, char[] signs, int[] values) {
    int minIndex = 0;
    int maxIndex = b.length - 1;

    for (int i = 0; i < regions.length; ++i) {
      if (signs[i] == '<') {
        maxIndex = Math.min(maxIndex, findMaxIndex(b, regions[i] - 1, values[i]));
      } else {
        minIndex = Math.max(minIndex, findMinIndex(b, regions[i] - 1, values[i]));
      }
    }

    return (minIndex <= maxIndex) ? (minIndex + 1) : -1;
  }

  static int findMaxIndex(int[][] b, int c, int value) {
    int result = -1;
    int lower = 0;
    int upper = b.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (b[middle][c] < value) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static int findMinIndex(int[][] b, int c, int value) {
    int result = b.length;
    int lower = 0;
    int upper = b.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (b[middle][c] > value) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}
