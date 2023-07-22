import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long c = sc.nextLong();
      int[] s = new int[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(s, c));
    }

    sc.close();
  }

  static int solve(int[] s, long c) {
    int lower = 1;
    int upper = Integer.MAX_VALUE;
    while (true) {
      int middle = lower + (upper - lower) / 2;
      int cmp =
          Arrays.stream(s)
              .mapToLong(si -> (si + 2L * middle) * (si + 2L * middle))
              .mapToObj(BigInteger::valueOf)
              .reduce(BigInteger::add)
              .get()
              .compareTo(BigInteger.valueOf(c));
      if (cmp < 0) {
        lower = middle + 1;
      } else if (cmp > 0) {
        upper = middle - 1;
      } else {
        return middle;
      }
    }
  }
}
