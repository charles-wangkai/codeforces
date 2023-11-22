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
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x, m));
    }

    sc.close();
  }

  static int solve(int[] x, int m) {
    int[] taken =
        IntStream.concat(IntStream.of(0, m + 1), Arrays.stream(x).filter(xi -> xi > 0))
            .distinct()
            .sorted()
            .toArray();
    int leftCount = (int) Arrays.stream(x).filter(xi -> xi == -1).count();
    int rightCount = (int) Arrays.stream(x).filter(xi -> xi == -2).count();

    return IntStream.range(0, taken.length)
        .map(
            i ->
                Math.min(taken[i] - i, leftCount)
                    + Math.min((m + 1 - taken[i]) - (taken.length - 1 - i), rightCount)
                    + (taken.length - 2))
        .max()
        .getAsInt();
  }
}