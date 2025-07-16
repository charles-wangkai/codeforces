import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    char[][] field = new char[n][n];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < n; ++c) {
        field[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(field, k));

    sc.close();
  }

  static String solve(char[][] field, int k) {
    int n = field.length;

    int[][] counts = new int[n][n];
    for (int beginR = 0; beginR < n; ++beginR) {
      for (int beginC = 0; beginC < n; ++beginC) {
        int beginR_ = beginR;
        int beginC_ = beginC;
        if (beginC + k <= n
            && IntStream.range(0, k).allMatch(i -> field[beginR_][beginC_ + i] == '.')) {
          for (int i = 0; i < k; ++i) {
            ++counts[beginR][beginC + i];
          }
        }
        if (beginR + k <= n
            && IntStream.range(0, k).allMatch(i -> field[beginR_ + i][beginC_] == '.')) {
          for (int i = 0; i < k; ++i) {
            ++counts[beginR + i][beginC];
          }
        }
      }
    }

    int bestR = 0;
    int bestC = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if (counts[r][c] > counts[bestR][bestC]) {
          bestR = r;
          bestC = c;
        }
      }
    }

    return "%d %d".formatted(bestR + 1, bestC + 1);
  }
}