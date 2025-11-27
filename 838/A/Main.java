import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] image = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        image[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(image));

    sc.close();
  }

  static int solve(char[][] image) {
    int n = image.length;
    int m = image[0].length;

    int maxK = Math.max(n, m);
    int size = maxK * 2;

    char[][] padded = new char[size][size];
    for (int r = 0; r < size; ++r) {
      for (int c = 0; c < size; ++c) {
        padded[r][c] = (r < n && c < m) ? image[r][c] : '0';
      }
    }

    int[][] prefixSums = new int[size + 1][size + 1];
    for (int i = 1; i <= size; ++i) {
      for (int j = 1; j <= size; ++j) {
        prefixSums[i][j] =
            prefixSums[i - 1][j]
                + prefixSums[i][j - 1]
                - prefixSums[i - 1][j - 1]
                + (padded[i - 1][j - 1] - '0');
      }
    }

    return IntStream.rangeClosed(2, maxK)
        .map(
            k -> {
              int result = 0;
              for (int rLength = k; rLength <= size; rLength += k) {
                for (int cLength = k; cLength <= size; cLength += k) {
                  int blockSum =
                      prefixSums[rLength][cLength]
                          - prefixSums[rLength - k][cLength]
                          - prefixSums[rLength][cLength - k]
                          + prefixSums[rLength - k][cLength - k];

                  result += Math.min(blockSum, k * k - blockSum);
                }
              }

              return result;
            })
        .min()
        .getAsInt();
  }
}