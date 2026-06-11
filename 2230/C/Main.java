import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c));
    }

    sc.close();
  }

  static long solve(int[] c) {
    if (Arrays.stream(c).asLongStream().sum() < 3 || c[c.length - 1] == 1) {
      return 0;
    }
    if (c.length == 1) {
      return c[c.length - 1];
    }

    int singleCount = (int) Arrays.stream(c).filter(ci -> ci == 1).count();

    long result = c[c.length - 1] + c[c.length - 2];
    if (singleCount == c.length - 1) {
      result = Math.max(result, c[c.length - 1] + Math.min(singleCount, c[c.length - 1] / 2));
    } else {
      result =
          Math.max(
              result,
              Arrays.stream(c).filter(ci -> ci != 1).asLongStream().sum()
                  + Math.min(
                      singleCount,
                      Arrays.stream(c).map(ci -> Math.max(0, ci / 2 - 1)).asLongStream().sum()));
    }

    return result;
  }
}