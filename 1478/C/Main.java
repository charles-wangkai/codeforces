import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long[] d = new long[2 * n];
      for (int i = 0; i < d.length; ++i) {
        d[i] = sc.nextLong();
      }

      System.out.println(solve(d) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(long[] d) {
    int n = d.length / 2;

    Arrays.sort(d);
    if (IntStream.range(0, n).anyMatch(i -> d[2 * i] != d[2 * i + 1])) {
      return false;
    }

    long[] values = new long[n];
    long rightSum = 0;
    for (int i = values.length - 1; i >= 0; --i) {
      long rest = d[i * 2] - rightSum * 2;
      if (rest % (2 * (i + 1)) != 0) {
        return false;
      }

      values[i] = rest / (2 * (i + 1));

      rightSum += values[i];
    }

    return values[0] > 0 && IntStream.range(0, n - 1).allMatch(i -> values[i] < values[i + 1]);
  }
}