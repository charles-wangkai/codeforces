import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] a = new int[2][n];
      for (int i = 0; i < 2; ++i) {
        String line = sc.next();
        for (int j = 0; j < n; ++j) {
          a[i][j] = line.charAt(j) - '0';
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[][] a) {
    int n = a[0].length;

    int upLastIndex = 0;
    while (upLastIndex != n - 1 && a[0][upLastIndex + 1] <= a[1][upLastIndex]) {
      ++upLastIndex;
    }

    int upLastBegin = upLastIndex;
    while (upLastBegin != 0 && a[0][upLastBegin] == a[1][upLastBegin - 1]) {
      --upLastBegin;
    }

    return String.format(
        "%s%s\n%d",
        IntStream.rangeClosed(0, upLastIndex)
            .map(i -> a[0][i])
            .mapToObj(String::valueOf)
            .collect(Collectors.joining()),
        IntStream.range(upLastIndex, n)
            .map(i -> a[1][i])
            .mapToObj(String::valueOf)
            .collect(Collectors.joining()),
        upLastIndex - upLastBegin + 1);
  }
}