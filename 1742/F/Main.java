import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int ALPHABET_SIZE = 26;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int q = sc.nextInt();
      int[] d = new int[q];
      int[] k = new int[q];
      String[] x = new String[q];
      for (int i = 0; i < q; ++i) {
        d[i] = sc.nextInt();
        k[i] = sc.nextInt();
        x[i] = sc.next();
      }

      System.out.println(solve(d, k, x));
    }

    sc.close();
  }

  static String solve(int[] d, int[] k, String[] x) {
    long[] sCounts = new long[ALPHABET_SIZE];
    sCounts[0] = 1;

    long[] tCounts = new long[ALPHABET_SIZE];
    tCounts[0] = 1;

    boolean[] result = new boolean[d.length];
    for (int i = 0; i < d.length; ++i) {
      for (char c : x[i].toCharArray()) {
        if (d[i] == 1) {
          sCounts[c - 'a'] += k[i];
        } else {
          tCounts[c - 'a'] += k[i];
        }
      }

      result[i] = canSmaller(sCounts, tCounts);
    }

    return IntStream.range(0, result.length)
        .mapToObj(i -> result[i] ? "YES" : "NO")
        .collect(Collectors.joining("\n"));
  }

  static boolean canSmaller(long[] sCounts, long[] tCounts) {
    int sIndex = 0;
    while (sCounts[sIndex] == 0) {
      ++sIndex;
    }

    boolean sHasOther = IntStream.range(sIndex + 1, sCounts.length).anyMatch(i -> sCounts[i] != 0);

    int tIndex = tCounts.length - 1;
    while (tCounts[tIndex] == 0) {
      --tIndex;
    }

    boolean tHasOther = IntStream.range(0, tIndex).anyMatch(i -> tCounts[i] != 0);

    return sIndex < tIndex
        || (sIndex == tIndex
            && ((sCounts[sIndex] < tCounts[tIndex] && !sHasOther)
                || (sCounts[sIndex] == tCounts[tIndex] && !sHasOther && tHasOther)));
  }
}