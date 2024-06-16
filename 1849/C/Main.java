import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int BASE = 31;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int m = sc.nextInt();
      String s = sc.next();
      int[] l = new int[m];
      int[] r = new int[m];
      for (int i = 0; i < m; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(s, l, r));
    }

    sc.close();
  }

  static int solve(String s, int[] l, int[] r) {
    int[] prefixSums = new int[s.length() + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + (s.charAt(i - 1) - '0');
    }

    long[] prefixHashes = new long[s.length() + 1];
    for (int i = 1; i < prefixHashes.length; ++i) {
      prefixHashes[i] = prefixHashes[i - 1] * BASE + (s.charAt(i - 1) - '0');
    }

    long[] powers = new long[s.length() + 1];
    powers[0] = 1;
    for (int i = 1; i < powers.length; ++i) {
      powers[i] = powers[i - 1] * BASE;
    }

    long[] powerSums = new long[s.length() + 1];
    for (int i = 1; i < powerSums.length; ++i) {
      powerSums[i] = powerSums[i - 1] + powers[i - 1];
    }

    return (int)
        IntStream.range(0, l.length)
            .mapToLong(
                i ->
                    (powerSums[prefixSums[r[i]] - prefixSums[l[i] - 1]]
                            - (prefixHashes[r[i]]
                                - prefixHashes[l[i] - 1] * powers[r[i] - l[i] + 1]))
                        * powers[s.length() - r[i]])
            .distinct()
            .count();
  }
}