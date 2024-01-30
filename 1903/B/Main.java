import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int BIT_NUM = 30;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] M = new int[n][n];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          M[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(M));
    }

    sc.close();
  }

  static String solve(int[][] M) {
    int n = M.length;

    int[] a = new int[n];
    Arrays.fill(a, (1 << BIT_NUM) - 1);

    for (int b = 0; b < BIT_NUM; ++b) {
      for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
          if (((M[i][j] >> b) & 1) == 0) {
            a[i] &= ((1 << BIT_NUM) - 1) - (1 << b);
            a[j] &= ((1 << BIT_NUM) - 1) - (1 << b);
          }
        }
      }
    }

    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        if ((a[i] | a[j]) != M[i][j]) {
          return "NO";
        }
      }
    }

    return String.format(
        "YES\n%s", Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}