import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] c = new int[n];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }
    int[] t = new int[m];
    int[] d = new int[m];
    for (int i = 0; i < m; ++i) {
      t[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(a, c, t, d));

    sc.close();
  }

  static String solve(int[] a, int[] c, int[] t, int[] d) {
    int[] sortedIndices =
        IntStream.range(0, c.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> c[i]).thenComparing(i -> i))
            .mapToInt(Integer::intValue)
            .toArray();

    long[] result = new long[t.length];
    int pos = 0;
    for (int i = 0; i < result.length; ++i) {
      int rest = d[i];

      {
        int num = Math.min(rest, a[t[i] - 1]);
        result[i] += (long) c[t[i] - 1] * num;
        a[t[i] - 1] -= num;
        rest -= num;
      }

      while (rest != 0 && pos != sortedIndices.length) {
        int num = Math.min(rest, a[sortedIndices[pos]]);
        result[i] += (long) c[sortedIndices[pos]] * num;
        a[sortedIndices[pos]] -= num;
        rest -= num;

        if (a[sortedIndices[pos]] == 0) {
          ++pos;
        }
      }

      if (rest != 0) {
        result[i] = 0;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}